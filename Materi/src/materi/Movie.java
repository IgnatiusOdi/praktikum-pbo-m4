package materi;

public class Movie {
    private String judul, maker, kode ,type;
    private int price;
    private boolean status; //T ada, F dipinjam

    public Movie(String judul, String maker, String kode, String type, int price) {
        this.judul = judul;
        this.maker = maker;
        this.kode = kode;
        this.type = type;
        this.price = price;
        this.status = true;
    }

    public String displayMovie() {
        return kode+" - "+judul+" - "+maker+" - "+type;
    }

    public String listMovie() {
        String sstatus = ".";
        if (status) {
            sstatus = "Belum dipinjam";
        }
        return judul+" - "+sstatus;
    }
}
