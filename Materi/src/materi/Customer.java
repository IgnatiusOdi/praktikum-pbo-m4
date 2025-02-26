package materi;

import java.util.ArrayList;

public class Customer extends User{
    private ArrayList<Movie> movies = new ArrayList<>();
    private int saldo;

    public Customer(String username, String password) {
        super(username, password);
        this.saldo = 0;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void rentalMovie() {

    }

    public void kembalikanMovie() {

    }

    public void myMovies() {

    }
}
