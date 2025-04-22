import java.util.Objects;
public class Professor extends UniversityMember{
    private String department;

    public Professor(String name, String id, String email, String department){
        super(name, id, email);
        this.department = department;
    }

    @Override
    public String getRole(){
        return "Professor";
    }

    public String getDepartment(){
        return this.department;
    }

    @Override
    public String toString() {
        String lastName = this.getName().substring(this.getName().lastIndexOf(" ")+1);
        return "Prof. "+lastName+" ("+this.getEmail()+")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getEmail());
    }
}