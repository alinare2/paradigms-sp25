

public class Main {
    public static void main(String[] args) {
        //paradigms objects
        Professor santos = new Professor("Joanna C. S. Santos", "910000000", "joannacss@nd.edu", "CSE");
        TA micah = new TA("Micah Brody", "901000000", "mbrody@nd.edu");
        TA sahil = new TA("Sahil Khandelwal", "902000000", "skhandel@nd.edu");
        TA kaixiang = new TA("Kaixiang Zhao", "903000000", "kzhao5@nd.edu");
        TA ella = new TA("Ella Gerczak", "904000000", "egerczak@nd.edu");
        Course paradigms = new Course("Programming Paradigms", "CSE30332", santos);
        micah.assignToCourse(paradigms);
        sahil.assignToCourse(paradigms);
        kaixiang.assignToCourse(paradigms);
        ella.assignToCourse(paradigms);

        //second course
        Professor dingler = new Professor("Aaron Dingler", "920000000", "adingler@nd.edu", "CSE");
        TA john = new TA("John Flanagan", "905000000", "jflanag5@nd.edu");
        Course compArch = new Course("Computer Architecture", "CSE30321", dingler);
        john.assignToCourse(compArch);

        //students
        Student andrew = new Student("Andrew Linares", "902000001", "alinare2@nd.edu", "Computer Engineering");
        Student jon = new Student("Jon Doe", "902000002", "johndoe@nd.edu", "Computer Science");
        Student jane = new Student("Jane Doe", "902000003", "janedoe@nd.edu", "Electrical Engineering");

        //enrollment
        paradigms.addStudent(andrew);
        compArch.addStudent(andrew);
        paradigms.addStudent(jon);
        compArch.addStudent(jon);
        paradigms.addStudent(jane);
        compArch.addStudent(jane);

        //checking
        // System.out.println(santos);

        // TA ta1 = micah;
        // ta1.assignToCourse(compArch);
        // for (Course c: ta1.getCourseAssisting()){
        //     if(c != null){
        //         System.out.println(c.getCode());
        //     }
        // }

        // System.out.println(micah);

        // Course course1 = paradigms;
        // for (Student s: course1.getEnrolledStudents()){
        //     if(s != null){
        //         System.out.println(s);
        //     }
        // }

    }
}