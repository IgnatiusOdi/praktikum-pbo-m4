package tugas;

public class Jaring {
    private String simbol;
    private int x,y;

    public Jaring(int x, int y) {
        this.simbol = "#";
        this.x = x;
        this.y = y;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
