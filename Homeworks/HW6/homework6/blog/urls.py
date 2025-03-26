from django.urls import path
from . import views

app_name = 'blog'

urlpatterns = [
   path('index', views.index),
   # TODO: add URL bindings for the 4 features
   path('', views.HomeView.as_view()),
   # blogs/<pk>/
    path('<int:pk>/', views.BlogView.as_view(), name='blog'),
]