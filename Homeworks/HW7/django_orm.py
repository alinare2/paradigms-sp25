# Q1.1: Write a query that retrieve all questions: 
all_questions = Question.objects.all() # your query here

# Q1.2: Write a query that retrieve all the choices for the question with a primary key equals to 1:
choices_for_q1 = Choice.objects.filter(question_id = 1) # your query here

# Q1.3: Write a query that retrieve all the questions published in 2023: 
questions_in_2023 = Question.objects.filter(pub_date__year=2023)# your query here

# Q1.4: Write a query that sum up the total number of votes for all choices for the question with ID = 1: 
total_votes = Choice.objects.filter(question_id=1).aggregate(Sum('votes'))# your query here

# Q1.5: Retrieve all questions sorted by publication date in descending order: 
questions_desc_order = Question.objects.order_by('-pub_date') # your query here