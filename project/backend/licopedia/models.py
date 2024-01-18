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


class Soda(models.Model):
    name = models.CharField(max_length=150)
    description = models.TextField()
    image = models.URLField()


class Liquor(models.Model):
    name = models.CharField(max_length=150)
    description = models.TextField()
    image = models.URLField()


class Cocktails(models.Model):
    name = models.CharField(max_length=150)
    description = models.TextField()
    image = models.URLField()
    soda = models.ForeignKey(Soda, on_delete=models.CASCADE)
    liquor = models.ForeignKey(Liquor, on_delete=models.CASCADE)