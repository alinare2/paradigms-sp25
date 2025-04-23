
public class Point {
    private int x;
    private int y;


    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(){ //cartesian distance from origin of point
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    @Override
    public boolean equals(Object other){
        // reflexive
        if(other == this) 
            return true; 
        // non-null
        if(other == null) 
            return false;
        // don't even bother! they have different types
        if(getClass() != other.getClass()) 
            return false;
        Point point = (Point) other; 
        
        //returns the boolean value of the cartesian distance from origin of each point
        return this.distance() == point.distance();
    }

    @Override
    public int hashCode(){
        int hash = 41 + x;
        hash = 41 * hash + y;
        return hash;
    }

    public static void main(String[] args) {
        Point p1 = new Point(2,3); 
        Point  p2 = new Point(-3,1);
        Point p3 = new Point(-2,-3);
        System.out.println(p1.equals(p2));  // → false because p1 and p2 are not equally distant to the origin 
        System.out.println(p1.equals(p3));  // → true  because p1 and p3 are equally distant to the origin
        System.out.println(p1.equals(null)); // → false  because according to the non-null rule, an object should never be equals to null
        System.out.println(p1.equals(p1));  // → true  because according to the reflexity rule, an object should be equals to itself
    }

}
