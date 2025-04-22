
import java.util.Objects;
public class Student extends UniversityMember{
    private String major;

    public Student(String name, String id, String email, String major){
        super(name, id, email);
        this.major =  major;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public String getMajor(){
        return this.major;
    }

    @Override
    public String toString() {
        return this.getName() + " ("+this.getEmail()+") - Major: " +this.getMajor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getEmail(), this.getMajor());
    }
}