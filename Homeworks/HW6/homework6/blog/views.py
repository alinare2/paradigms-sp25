from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render, get_object_or_404
from django.urls import reverse

from .models import Blog
from django.views.generic import ListView, DetailView

# Create your views here.
def index(request):
    # return HttpResponse('Hello')
    blogs = Blog.objects.all()

    return render(request,
                  template_name='index.html',
                  context={})

# list view of blogs
class HomeView(ListView):
    template_name = 'blog/list_blog.html'
    context_object_name = "blogs"

    # query latest 5 questions
    def get_queryset(self):
        return Blog.objects.order_by('-pub_date')
class BlogView(DetailView):
    model = Blog
    template_name = "blog/blog_content.html"