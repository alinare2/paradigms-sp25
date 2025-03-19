from question3 import Student, Professor, TA, Course

if __name__ == "__main__": 

    profSantos = Professor("Joanna Santos", 902000000, "jdasilv2@nd.edu", "CSE")

    ta_1 = TA("Micah Brody",902000010,"mbrody@nd.edu")
    ta_2 = TA("Sahil Khandelwal",902000011,"skhandel@nd.edu")
    ta_3 = TA("Kaixiang Zhao",902000012,"kzhao5@nd.edu")
    ta_4 = TA("Ella Gerczak",902000013,"egerczak@nd.edu")

    student_1 = Student("Cesar De Leon",902000100, "cdeleon2@nd.edu", "Computer Science")
    student_2 = Student("Sajith Devareddy",902000101, "sdevared@nd.edu", "Computer Science")
    student_3 = Student("Andrew Linares",902000102, "alinare2@nd.edu", "Computer Engineering")

    paradigms = Course("Paradigms", "30332", profSantos)

    # #testing 
    # print(profSantos)
    # ta_1.assign_to_course(paradigms)
    # print(ta_1)
    # print(student_1)