from abc import ABC, abstractmethod

class UniversityMember(ABC):
    num_members = 0
    def __init__(self, name:str, memberId:int, email:str):
        self.name = name
        self.memberId = memberId
        self.email = email
        UniversityMember.num_members += 1
    @abstractmethod
    def get_role():
        pass

class Student(UniversityMember):
    def __init__(self, name:str, memberId:int, email:str, major:str):
        super().__init__(name, memberId, email)
        self.major = major
    def get_role():
        return "Student"
    def __str__(self):
        return f'{self.name} ({self.email}) - Major: {self.major}'

class Professor(UniversityMember):
    def __init__(self, name:str, memberId:int, email:str, department:str):
        super().__init__(name, memberId, email)
        self.department = department
    def get_role():
        return "Professor"
    def __str__(self):
        return f'Prof. {self.name} ({self.email})'

class Course:
    def __init__(self, name:str, code:str, instructor:Professor):
        self.name = name
        self.code = code
        self.instructor = instructor
        self.enrolled_students = []
    def addStudent(self, student: Student):
        self.enrolled_students.append(student)
    def removeStudent(self, student: Student):
        self.enrolled_students.remove(student)
    def addInstructor(self, instructor: Professor):
        self.instructor = instructor
    def removeInstructor(self, instructor: Professor):
        self.instructor = "" #empty until new instructor added

class TA(UniversityMember):
    def __init__(self, name:str, memberId:int, email:str):
        super().__init__(name, memberId, email)
        self.courses_assisting = []
    def get_role():
        return "TA"
    def assign_to_course(self, course: Course):
        self.courses_assisting.append(course.code)
    def __str__(self):
        return f'{self.name} ({self.email}). TA for Courses: {", ".join(x for x in self.courses_assisting)}.'

