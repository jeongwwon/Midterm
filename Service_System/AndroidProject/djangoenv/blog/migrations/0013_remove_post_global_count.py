# Generated by Django 4.2.7 on 2023-11-22 07:41

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('blog', '0012_post_count'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='post',
            name='global_count',
        ),
    ]
