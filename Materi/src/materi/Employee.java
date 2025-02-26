package materi;

import java.util.*;

public class Employee extends User{
    static ArrayList<Movie> allMovies = new ArrayList<>();
    static ArrayList<RequestedRental> daftarRequest = new ArrayList<>();

    public Employee(String username, String password) {
        super(username, password);
    }

    public void acceptRental() {

    }
}
