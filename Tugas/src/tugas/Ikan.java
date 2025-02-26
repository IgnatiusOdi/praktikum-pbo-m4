package tugas;

import java.util.*;

public class Ikan {
    protected String jenis, simbol;
    protected int hp, x, y, ctrmakan, ctrgerak;
    Random rnd = new Random();

    public Ikan(String jenis, String simbol, int hp, int x, int y) {
        this.jenis = jenis;
        this.simbol = simbol;
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.ctrmakan = 0;
        this.ctrgerak = 0;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public int getCtrmakan() {
        return ctrmakan;
    }

    public void setCtrmakan(int ctrmakan) {
        this.ctrmakan = ctrmakan;
    }

    public int getCtrgerak() {
        return ctrgerak;
    }

    public void setCtrgerak(int ctrgerak) {
        this.ctrgerak = ctrgerak;
    }

    public int randomX() {
        return rnd.nextInt(25)+1;
    }

    public int randomY() {
        return rnd.nextInt(5)+1;
    }


}
