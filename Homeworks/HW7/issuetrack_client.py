import requests
from requests.auth import HTTPBasicAuth
import csv
import re
from collections import defaultdict


URL = "http://jcssdev.pythonanywhere.com/"

# generate the csv for the bug package count
def generate_bug_csv(bug_counts):	
	with open("total_bugs_per_package.csv", "w", newline='') as csvfile:
		writer = csv.writer(csvfile)
		writer.writerow(["package", "total"])
		for package, count in bug_counts.items():
			writer.writerow([package, count])
    
# generate the csv of comments bug count
def generate_comments_csv(comment_counts):	
	with open("total_comments_per_bug.csv", "w", newline='') as csvfile:
		writer = csv.writer(csvfile)
		writer.writerow(["bug_id", "total"])
		for bug_id, count in comment_counts.items():
			writer.writerow([bug_id, count])

def visit_bugs(): #visits bugs and creates a dictionary object with bug package count
		# composes request URL
		url = URL + "bugs"
		# while the `next` page to visit is not None
		bug_counts = defaultdict(int)
		while url:
			print(url)
			# HTTP request without authentication
			response = requests.get(url)
			if response:
				# parse the response to JSON
				json_resp = response.json()
				# get the next page
				url = json_resp["next"] 
				# parse the returned user information
				bugs = json_resp["results"]
				
				for bug in bugs:
					package = bug.get("package")
					bug_counts[package] += 1
					
			else:
				url = None
		generate_bug_csv(bug_counts)
def visit_comments(): #visits comments and creates dictionary of comment bug count
		# composes request URL
		url = URL + "comments"
		# while the `next` page to visit is not None
		comment_counts = defaultdict(int)
		while url:
			print(url)
			# HTTP request without authentication
			response = requests.get(url)
			if response:
				# parse the response to JSON
				json_resp = response.json()
				# get the next page
				url = json_resp["next"] 
				# parse the returned user information
				comments = json_resp["results"]
				
				for comment in comments:
					bug = comment.get("bug")
					bug_id = extract_bug_id(bug)
					comment_counts[bug_id] += 1
			else:
				url = None
		generate_comments_csv(comment_counts)


def extract_bug_id(bug_url):
    match = re.search(r'/bugs/(\d+)/', bug_url)
    return int(match.group(1))

def main():
	visit_bugs()
	visit_comments()
	


if __name__ == '__main__':
	main()