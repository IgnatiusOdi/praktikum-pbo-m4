package tugas;

public class NemoMuda extends Ikan {

    private int dropkoin;

    public NemoMuda(int x, int y) {
        super("Ikan Nemo Muda", "i", 10, x, y);
        this.dropkoin = 0;
    }

    public int getDropkoin() {
        return dropkoin;
    }

    public void setDropkoin(int dropkoin) {
        this.dropkoin = dropkoin;
    }
}
