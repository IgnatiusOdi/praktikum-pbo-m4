package materi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);

        ArrayList<Customer> customer = new ArrayList<>();
        ArrayList<Employee> employee = new ArrayList<>();
        ArrayList<Movie> movie = new ArrayList<>();
        Display display = new Display();

        do{
            System.out.println("======Rental XXI======");
            System.out.print("Username: ");
            String username = scan.nextLine();
            System.out.print("Password: ");
            String password = scan.nextLine();

            if (username.equals("admin") && password.equals("admin")) {
                do{
                    display.adminMenu();
                    int menu = scanint.nextInt();
                    if (menu == 1) {
                        //REGISTER CUSTOMER
                        System.out.println("======Register Customer======");
                        System.out.print("Username: ");
                        username = scan.nextLine();
                        System.out.print("Password");
                        password = scan.nextLine();

                        boolean ada = false;
                        for (Customer c : customer) {
                            if (username.equals(c.getUsername())) {
                                ada = true;
                                break;
                            }
                        }
                        for (Employee e : employee) {
                            if (username.equals(e.getUsername())) {
                                ada = true;
                                break;
                            }
                        }
                        if (ada) {
                            System.out.println("Username is already used!");
                        } else {
                            customer.add(new Customer(username,password));
                            System.out.println("Customer berhasil didaftarkan!");
                        }
                    } else if (menu == 2) {
                        //REGISTER EMPLOYEE
                        System.out.println("======Register Employee======");
                        System.out.print("Username: ");
                        username = scan.nextLine();
                        System.out.print("Password");
                        password = scan.nextLine();

                        boolean ada = false;
                        for (Customer c : customer) {
                            if (username.equals(c.getUsername())) {
                                ada = true;
                                break;
                            }
                        }
                        for (Employee e : employee) {
                            if (username.equals(e.getUsername())) {
                                ada = true;
                                break;
                            }
                        }
                        if (ada) {
                            System.out.println("Username is already used!");
                        } else {
                            employee.add(new Employee(username,password));
                            System.out.println("Employee berhasil didaftarkan!");
                        }
                    } else if (menu == 3) {
                        //ADD MOVIE
                        System.out.print("Movie Name: ");
                        String moviename = scan.nextLine();
                        System.out.print("Movie Maker: ");
                        String moviemaker = scan.nextLine();
                        System.out.print("Type: ");
                        String movietype = scan.nextLine();
                        int movieprice = 0;
                        if (movietype.equals("Free")) {
                            movieprice = 0;
                        } else if (movietype.equals("Paid")) {
                            System.out.println("Price: ");
                            movieprice = scanint.nextInt();
                        }
                        if (movieprice < 0) {
                            System.out.println("Error Price < 0");
                        } else {
                            String kata1 = moviename.substring(0,1);
                            String kata2 = moviename.substring(moviename.indexOf(' ')+1,1);
                            String kode = "M"+kata1.toUpperCase()+kata2.toUpperCase()+"001";
                            movie.add(new Movie(moviename,moviemaker,kode,movietype,movieprice));
                            System.out.println("\""+moviename+"\" Movie ("+kode+") has succesfully been added!");
                        }
                    } else if (menu == 4) {
                        //LIST MOVIE
                        System.out.println("======List Movie======");
                        for (Movie m : movie) {
                            System.out.println((movie.indexOf(m)+1)+". "+m.displayMovie());
                        }
                    } else if (menu == 5) {
                        //LIST ALL USER
                        System.out.println("======List User======");
                        int counter = 0;
                        for (Customer c : customer) {
                            ++counter;
                            System.out.println(counter+". "+c.getUsername());
                        }
                        for (Employee e : employee) {
                            ++counter;
                            System.out.println(counter+". "+e.getUsername());
                        }
                    } else if (menu == 6) {
                        //ISI SALDO
                        System.out.println("======Isi Saldo======");
                        for (Customer c : customer) {
                            System.out.println(customer.indexOf(c)+". "+c.getUsername());
                        }
                        System.out.print(">> ");
                        int pilih = scanint.nextInt();
                        if (pilih <= customer.size()) {
                            pilih--;
                            int saldo;
                            do{
                                System.out.println("Masukkan Saldo: ");
                                saldo = scanint.nextInt();
                                if (saldo <= 0) {
                                    System.out.println("Invalid Input!");
                                } else {
                                    customer.get(pilih).setSaldo(customer.get(pilih).getSaldo()+saldo);
                                    System.out.println("Berhasil isi saldo!");
                                }
                            }while(saldo <= 0);
                        }
                    } else if (menu == 7) {
                        //EXIT
                        break;
                    }
                }while(true);
            }
            else {
                boolean cust = false;
                boolean emp = false;
                int idx = 0;
                for (Customer c : customer) {
                    if (username.equals(c.getUsername())) {
                        cust = true;
                        idx = customer.indexOf(c);
                        break;
                    }
                }
                for (Employee e : employee) {
                    if (username.equals(e.getUsername())) {
                        emp = true;
                        idx = employee.indexOf(e);
                        break;
                    }
                }
                if (cust) {
                    do{
                        System.out.println("======Rental XXI======");
                        System.out.println("======Menu Customer======");
                        System.out.println("Welcome, "+customer.get(idx).getUsername()+"!");
                        System.out.println("Saldo : "+customer.get(idx).getSaldo());
                        System.out.println("1. Rental Movie");
                        System.out.println("2. Kembalikan Movie");
                        System.out.println("3. My Movies");
                        System.out.println("4. Exit Menu");
                        System.out.print(">> ");
                        int menu = scanint.nextInt();
                        if (menu == 1) {
                            //RENTAL MOVIE

                        } else if (menu == 2) {
                            //KEMBALIKAN MOVIE

                        } else if (menu == 3) {
                            //MY MOVIES

                        } else if (menu == 4) {
                            //EXIT
                            break;
                        }
                    }while(true);
                } else if (emp) {
                    do{
                        System.out.println("======Rental XXI======");
                        System.out.println("======Menu Employee======");
                        System.out.println("Welcome, "+employee.get(idx).getUsername()+"!");
                        System.out.println("1. Accept Rental");
                        System.out.println("2. List Movie");
                        System.out.println("3. Exit Menu");
                        System.out.print(">> ");
                        int menu = scanint.nextInt();
                        if (menu == 1) {
                            //ACCEPT RENTAL

                        } else if (menu == 2) {
                            //LIST MOVIE
                            for (Movie m : movie) {
                                System.out.println(movie.indexOf(m)+". "+m.listMovie());
                            }
                        } else if (menu == 3) {
                            //EXIT
                            break;
                        }
                    }while(true);
                }
            }
        }while(true);
    }
}
