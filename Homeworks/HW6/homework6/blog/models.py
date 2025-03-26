from django.db import models

# Create your models here.
class Blog(models.Model):
    blog_title = models.CharField(max_length=200)
    blog_content = models.TextField()
    blog_author = models.CharField(max_length=200)
    pub_date = models.DateTimeField()

    def __str__(self):
        return f"{self.blog_title} by {self.blog_author} ({self.pub_date})"
