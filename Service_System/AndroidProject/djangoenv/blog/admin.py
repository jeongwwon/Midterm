from django.contrib import admin

from django.contrib import admin
from .models import Post,GlobalPostCount

admin.site.register(Post)
admin.site.register(GlobalPostCount)