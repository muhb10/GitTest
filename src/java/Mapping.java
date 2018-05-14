
public class Mapping {
    
    private int X;
    private int Y;
    private String name;

    public Mapping() {
    }
 
    public Mapping(int X, int Y, String name) {
        this.X = X;
        this.Y = Y;
        this.name = name;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mapping{" + "X=" + X + ", Y=" + Y + ", name=" + name + '}';
    }

    
}
