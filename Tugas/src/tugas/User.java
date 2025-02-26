package tugas;

import java.util.*;

public class User {
    private String nama;
    private int koin, score, movecounter, foodlevel, jaringlevel;
    ArrayList<IbuNemo> ibunemo = new ArrayList<>();
    ArrayList<NemoMuda> nemomuda = new ArrayList<>();
    ArrayList<NemoDewasa> nemodewasa = new ArrayList<>();
    ArrayList<MonsterKecil> monsterkecil = new ArrayList<>();
    ArrayList<MonsterBesar> monsterbesar = new ArrayList<>();

    // USER DEFAULT
    public User(String nama) {
        this.nama = nama;
        this.score = 0;
        this.koin = 0;
        this.movecounter = 0;
        this.foodlevel = 1;
        this.jaringlevel = 1;
    }

    // HIGHSCORE
    public User(String nama, int score) {
        this.nama = nama;
        this.score = score;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getKoin() {
        return koin;
    }

    public void setKoin(int koin) {
        this.koin = koin;
    }

    public int getMovecounter() {
        return movecounter;
    }

    public void setMovecounter(int movecounter) {
        this.movecounter = movecounter;
    }

    public int getFoodlevel() {
        return foodlevel;
    }

    public void setFoodlevel(int foodlevel) {
        this.foodlevel = foodlevel;
    }

    public int getJaringlevel() {
        return jaringlevel;
    }

    public void setJaringlevel(int jaringlevel) {
        this.jaringlevel = jaringlevel;
    }

    public int getJumlahmonster() {
        return getJumlahmonsterbesar()+getJumlahmonsterkecil();
    }

    public int getJumlahmonsterbesar() {
        return monsterbesar.size();
    }

    public String getMonsterbesar(int idx) {
        return monsterbesar.get(idx).getJenis()+" ("+monsterbesar.get(idx).getSimbol()+") - ("+monsterbesar.get(idx).getX()+","+monsterbesar.get(idx).getY()+")"+" - "+monsterbesar.get(idx).getHp()+" HP";
    }

    public int getJumlahmonsterkecil() {
        return monsterkecil.size();
    }

    public String getMonsterkecil(int idx) {
        return monsterkecil.get(idx).getJenis()+" ("+monsterkecil.get(idx).getSimbol()+") - ("+monsterkecil.get(idx).getX()+","+monsterkecil.get(idx).getY()+")"+" - "+monsterkecil.get(idx).getHp()+" HP";
    }

    public int getJumlahnemomuda() {
        return nemomuda.size();
    }

    public String getNemomuda(int idx) {
        return nemomuda.get(idx).getJenis()+" - "+nemomuda.get(idx).getCtrmakan()+" Food - ("+nemomuda.get(idx).getX()+","+nemomuda.get(idx).getY()+") - "+nemomuda.get(idx).getHp()+" HP";
    }

    public String getNemomudastep(int idx) {
        return nemomuda.get(idx).getJenis()+" - "+nemomuda.get(idx).getCtrmakan()+" Food - "+nemomuda.get(idx).getCtrgerak()+" Steps - ("+nemomuda.get(idx).getX()+","+nemomuda.get(idx).getY()+") - "+nemomuda.get(idx).getHp()+" HP";
    }

    public int getJumlahnemodewasa() {
        return nemodewasa.size();
    }

    public String getNemodewasa(int idx) {
        return nemodewasa.get(idx).getJenis()+" - "+nemodewasa.get(idx).getCtrmakan()+" Food - ("+nemodewasa.get(idx).getX()+","+nemodewasa.get(idx).getY()+") - "+nemodewasa.get(idx).getHp()+" HP";
    }

    public String getNemodewasastep(int idx) {
        return nemodewasa.get(idx).getJenis()+" - "+nemodewasa.get(idx).getCtrmakan()+" Food - "+nemodewasa.get(idx).getCtrgerak()+" Steps - ("+nemodewasa.get(idx).getX()+","+nemodewasa.get(idx).getY()+") - "+nemodewasa.get(idx).getHp()+" HP";
    }

    public int getJumlahibunemo() {
        return ibunemo.size();
    }

    public String getIbunemo(int idx) {
        return ibunemo.get(idx).getJenis()+" - "+ibunemo.get(idx).getCtrmakan()+" Food - ("+ibunemo.get(idx).getX()+","+ibunemo.get(idx).getY()+") - "+ibunemo.get(idx).getHp()+" HP";
    }

    public String getIbunemostep(int idx) {
        return ibunemo.get(idx).getJenis()+" - "+ibunemo.get(idx).getCtrmakan()+" Food - "+ibunemo.get(idx).getCtrgerak()+" Steps - ("+ibunemo.get(idx).getX()+","+ibunemo.get(idx).getY()+") - "+ibunemo.get(idx).getHp()+" HP";
    }

    public int getJumlahikantotal() {
        return getJumlahibunemo()+getJumlahnemomuda()+getJumlahnemodewasa();
    }

    public void beriMakanikan() {
        int ctr = 1;
        for (int i = 0; i < nemomuda.size(); i++) {
            System.out.println(ctr+". "+getNemomuda(i));
            ctr++;
        }
        for (int i = 0; i < nemodewasa.size(); i++) {
            System.out.println(ctr+". "+getNemodewasa(i));
            ctr++;
        }
        for (int i = 0; i < ibunemo.size(); i++) {
            System.out.println(ctr+". "+getIbunemo(i));
            ctr++;
        }
    }

    public void ikanSaya() {
        int ctr = 1;
        for (int i = 0; i < nemomuda.size(); i++) {
            System.out.println(ctr+". "+getNemomudastep(i));
            ctr++;
        }
        for (int i = 0; i < nemodewasa.size(); i++) {
            System.out.println(ctr+". "+getNemodewasastep(i));
            ctr++;
        }
        for (int i = 0; i < ibunemo.size(); i++) {
            System.out.println(ctr+". "+getIbunemostep(i));
            ctr++;
        }
    }

    public void jualIkan() {
        int ctr = 1;
        for (int i = 0; i < nemomuda.size(); i++) {
            System.out.println(ctr+". "+getNemomudastep(i));
            ctr++;
        }
        for (int i = 0; i < nemodewasa.size(); i++) {
            System.out.println(ctr+". "+getNemodewasastep(i));
            ctr++;
        }
        for (int i = 0; i < ibunemo.size(); i++) {
            System.out.println(ctr+". "+getIbunemostep(i));
            ctr++;
        }
    }

    public void listMonster() {
        int ctr = 1;
        for (int i = 0; i < monsterbesar.size(); i++) {
            System.out.println(ctr+". "+getMonsterbesar(i));
            ctr++;
        }
        for (int i = 0; i < monsterkecil.size(); i++) {
            System.out.println(ctr+". "+getMonsterkecil(i));
            ctr++;
        }
    }

}
