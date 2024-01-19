import json
import secrets
import bcrypt
from django.core.exceptions import ObjectDoesNotExist

from django.views import View
from django.http import HttpResponse
from django.http import JsonResponse
from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt

from .models import *


# Create your views here.

@csrf_exempt
def sessions(request):
    if request.method != 'POST':
        return JsonResponse({'error': 'Not supported HTTP method'}, status=405)
    body_json = json.loads(request.body)
    required_params = ['email', 'password']
    missing_params = [param for param in required_params if param not in body_json]
    if missing_params:
        return JsonResponse({"error": "You are missing a parameter"}, status=400)
    json_email = body_json['email']
    json_password = body_json['password']
    try:
        db_user = CustomUser.objects.get(email=json_email)
    except CustomUser.DoesNotExist:
        return JsonResponse({"error": "User not in database"}, status=404)

    if bcrypt.checkpw(json_password.encode('utf8'), db_user.password.encode('utf8')):
        random_token = secrets.token_hex(10)
        session = UserSession(user=db_user, token=random_token)
        session.save()
        return JsonResponse({"token": random_token}, status=201)
    else:
        return JsonResponse({"error": "Invalid password"}, status=401)


@csrf_exempt
def register(request):
    if request.method != 'POST':
        return JsonResponse({'error': 'Unsupported HTTP method'}, status=405)

    body_json = json.loads(request.body)
    required_params = ['name', 'email', 'password']

    if not all(param in body_json for param in required_params):
        return JsonResponse({'error': 'Missing parameter in body request'}, status=400)

    json_name = body_json['name']
    json_email = body_json['email']
    json_password = body_json['password']

    if '@' not in json_email or len(json_email) < 5:
        return JsonResponse({'error': 'Not valid email'}, status=400)

    if CustomUser.objects.filter(email=json_email).exists():
        return JsonResponse({'error': 'User already registered.'}, status=401)

    salted_and_hashed_pass = bcrypt.hashpw(json_password.encode('utf8'), bcrypt.gensalt()).decode('utf8')

    user_object = CustomUser(name=json_name, email=json_email, password=salted_and_hashed_pass)
    user_object.save()

    # Generamos un token para el usuario
    token = secrets.token_hex(16)

    # Guardamos la session
    user_session = UserSession(user=user_object, token=token)
    user_session.save()

    return JsonResponse({"token": token}, status=200)


def saved_cocktails(request):
    if request.method != "GET":
        return JsonResponse({'error': 'Unsupported HTTP method'}, status=405)

    if request.method == "GET":
        # user_token = request.GET.get('token')
        user_token = request.headers.get('Authorization')

        if not user_token:
            return JsonResponse({'error': 'Missing token parameter in the request'}, status=400)

        try:
            username = UserSession.objects.get(token=user_token)
            user = CustomUser.objects.get(username=username)
            user_cocktails = SavedCocktails.objects.filter(user=user)
            json_response = []

            for saved_cocktail in user_cocktails:
                cocktail_data = saved_cocktail.cocktail.to_json()
                json_response.append(cocktail_data)

            return JsonResponse({'cocktails': json_response}, safe=False)

        except ObjectDoesNotExist:
            return JsonResponse({'error': 'User not found or invalid token'}, status=404)

    return JsonResponse({'error': 'Invalid request'}, status=400)
