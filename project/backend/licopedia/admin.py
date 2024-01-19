from django.contrib import admin
from .models import *

# Register your models here.
admin.site.register(CustomUser)
admin.site.register(Cocktails)
admin.site.register(SavedCocktails)
admin.site.register(Liquor)
admin.site.register(UserSession)
admin.site.register(Soda)