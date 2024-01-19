from django.db import models


# Create your models here.

class CustomUser(models.Model):
    username = models.CharField(max_length=150)
    name = models.CharField(max_length=150)
    surname = models.CharField(max_length=150)
    email = models.CharField(max_length=300)
    password = models.CharField(max_length=255)
    address = models.CharField(max_length=255, null=True, blank=True)
    telephone = models.IntegerField(null=True, blank=True)

    def __str__(self):
        return self.name

    def to_json_edit_user(self):
        return {
            "username": self.username,
            "name": self.name,
            "surname": self.surname,
            "email": self.email,
            "password": self.password
        }

    def to_json_personal_data(self):
        return {
            "email": self.email,
            "password": self.password,
            "address": self.address,
            "telephone": self.telephone
        }

    def to_json_all(self):
        return {
            "username": self.username,
            "name": self.name,
            "surname": self.surname,
            "email": self.email,
            "password": self.password,
            "address": self.address,
            "telephone": self.telephone
        }


class UserSession(models.Model):
    user = models.ForeignKey(CustomUser, on_delete=models.CASCADE)
    token = models.CharField(unique=True, max_length=45)

    def __str__(self):
        return self.user.name


class Soda(models.Model):
    name = models.CharField(max_length=150)
    description = models.TextField()
    image = models.URLField()

    def __str__(self):
        return self.name

    def to_json(self):
        return {
            "name": self.name,
            "description": self.description,
            "image": self.image,
        }


class Liquor(models.Model):
    name = models.CharField(max_length=150)
    description = models.TextField()
    image = models.URLField()

    def __str__(self):
        return self.name

    def to_json(self):
        return {
            "name": self.name,
            "description": self.description,
            "image": self.image,
        }


class Cocktails(models.Model):
    name = models.CharField(max_length=150)
    description = models.TextField()
    image = models.URLField()
    soda = models.ForeignKey(Soda, on_delete=models.CASCADE)
    liquor = models.ForeignKey(Liquor, on_delete=models.CASCADE)

    class Meta:
        verbose_name_plural = "Cocktails"

    def __str__(self):
        return self.name

    def to_json(self):
        return {
            "name": self.name,
            "description": self.description,
            "image": self.image,
            "soda": self.soda.to_json(),
            "liquor": self.liquor.to_json(),
        }


class SavedCocktails(models.Model):
    user = models.ForeignKey(CustomUser, on_delete=models.CASCADE)
    cocktail = models.ForeignKey(Cocktails, on_delete=models.CASCADE)

    def __str__(self):
        return self.user.username

    class Meta:
        verbose_name_plural = "Saved Cocktails"

