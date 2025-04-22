import java.util.Objects;

public class TA extends UniversityMember {
    private Course[] courseAssisting = new Course[2];

    public TA(String name, String id, String email){
        super(name, id, email);
    }

    @Override
    public String getRole() {
        return "TA";
    }

    public void assignToCourse(Course c){
        for (int i=0; i < 2; i++){
            if (courseAssisting[i] == null){
                if (i == 1 && courseAssisting[0]==c){
                    return;
                }
                courseAssisting[i] = c;
                return;
            }
        }
    }

    public Course[] getCourseAssisting(){
        return this.courseAssisting;
    } 

    @Override
    public String toString() {
        String out = this.getName()+" ("+this.getEmail()+"). TA for Courses: ";
        
        //appending course assisting to the string
        Course[] courses= this.getCourseAssisting();
        for (int i=0; i < courses.length; i++){
            if (courses[i] != null){
                if (i == courses.length - 1){
                    out += courses[i].getCode() + ".";
                }
                else{
                    out += courses[i].getCode() + ", ";
                }
            }
        }
            
        
        return out;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getEmail(), this.getCourseAssisting());
    }

}