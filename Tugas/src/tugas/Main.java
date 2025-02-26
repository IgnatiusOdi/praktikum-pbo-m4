package tugas;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        ArrayList<User> user = new ArrayList<>();

        do{
            //u00BA
            System.out.println("======================");
            System.out.println("|            <º)))>< |");
            System.out.println("|                    |");
            System.out.println("|  <Insaniquarium>   |");
            System.out.println("|            <Game>  |");
            System.out.println("| ><(((º>            |");
            System.out.println("|                    |");
            System.out.println("======================");
            System.out.println("-------Main Menu-------");
            System.out.println("1. Play Game");
            System.out.println("2. Highscore");
            System.out.println("3. Exit");
            System.out.print(">> ");
            int menu = scanint.nextInt();
            if (menu == 1) {
                // PLAY GAME
                String[][] aquarium =
                        {
                                {"=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","="},
                                {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                                {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                                {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                                {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                                {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
                                {"=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","="}
                        };
                System.out.print("Masukkan nama : ");
                String nama = scan.nextLine();

                user.add(new User(nama));
                int idx = user.size()-1;
                User active = user.get(idx);

                ArrayList<KoinIkan> koin = new ArrayList<>();
                ArrayList<Jaring> jaring = new ArrayList<>();
                int x = rnd.nextInt(23)+1;
                int y = rnd.nextInt(5)+1;
                active.nemomuda.add(new NemoMuda(x,y));
                aquarium[y][x] = "i";
                do{
                    x = rnd.nextInt(23)+1;
                    y = rnd.nextInt(5)+1;
                    if (aquarium[y][x].equals(" ")) {
                        aquarium[y][x] = "B";
                        active.ibunemo.add(new IbuNemo(x,y));
                        break;
                    }
                }while(true);

                do{
                    // EMPTY AQUARIUM
                    for (int i = 1; i < 6; i++) {
                        for (int j = 1; j < 24; j++) {
                            aquarium[i][j] = " ";
                        }
                    }
                    // FILL KOIN
                    for (KoinIkan k : koin) {
                        aquarium[k.getY()][k.getX()] = k.getSimbol();
                    }
                    // FILL JARING
                    for (Jaring j : jaring) {
                        aquarium[j.getY()][j.getX()] = j.getSimbol();
                    }
                    // FILL IKAN
                    for (int i = 0; i < active.getJumlahnemomuda(); i++) {
                        aquarium[active.nemomuda.get(i).getY()][active.nemomuda.get(i).getX()] = active.nemomuda.get(i).getSimbol();
                    }
                    for (int i = 0; i < active.getJumlahnemodewasa(); i++) {
                        aquarium[active.nemodewasa.get(i).getY()][active.nemodewasa.get(i).getX()] = active.nemodewasa.get(i).getSimbol();
                    }
                    for (int i = 0; i < active.getJumlahibunemo(); i++) {
                        aquarium[active.ibunemo.get(i).getY()][active.ibunemo.get(i).getX()] = active.ibunemo.get(i).getSimbol();
                    }
                    // FILL MONSTER
                    for (int i = 0; i < active.getJumlahmonsterkecil(); i++) {
                        aquarium[active.monsterkecil.get(i).getY()][active.monsterkecil.get(i).getX()] = active.monsterkecil.get(i).getSimbol();
                    }
                    for (int i = 0; i < active.getJumlahmonsterbesar(); i++) {
                        aquarium[active.monsterbesar.get(i).getY()][active.monsterbesar.get(i).getX()] = active.monsterbesar.get(i).getSimbol();
                    }

                    // PRINT AQUARIUM
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 25; j++) {
                            System.out.print(aquarium[i][j]);
                        }
                        System.out.println();
                    }
                    System.out.println("========Menu Game========");
                    if (active.getJumlahmonster() > 0) {
                        System.out.println("!!! MONSTER DALAM MAP !!!");
                    }
                    System.out.println("Koin : "+active.getKoin()+" koin");
                    System.out.println("1. Beli Ikan");
                    System.out.println("2. Beri Makan");
                    System.out.println("3. Ambil Koin");
                    System.out.println("4. Ikan Saya");
                    System.out.println("5. Upgrade Shop");
                    System.out.println("6. Jual Ikan");
                    System.out.println("7. Gerakkan Ikan");
                    if (active.getJumlahmonster() > 0){
                        System.out.println("8. Bunuh Monster");
                    }
                    System.out.println("0. Surrender");
                    System.out.print(">> ");
                    String choice = scan.nextLine();
                    if (choice.equals("1")) {
                        // BELI IKAN
                        do{
                            System.out.println("========Beli Ikan========");
                            System.out.println("Koin : "+active.getKoin()+" Koin");
                            System.out.println("1. Ikan Nemo Muda (10 Koin) - (Total:"+active.getJumlahnemomuda()+")");
                            System.out.println("2. Ikan Nemo Dewasa (20 Koin) - (Total:"+active.getJumlahnemodewasa()+")");
                            System.out.println("3. Ibu Ikan (30 Koin) - (Total:"+active.getJumlahibunemo()+")");
                            System.out.println("0. Kembali ke Menu Game");
                            System.out.print(">> ");
                            menu = scanint.nextInt();
                            if (menu == 1) {
                                // NEMO MUDA
                                if (active.getKoin() >= 10) {
                                    active.setKoin(active.getKoin()-10);
                                    do{
                                        x = rnd.nextInt(23)+1;
                                        y = rnd.nextInt(5)+1;
                                        if (aquarium[y][x].equals(" ")) {
                                            active.nemomuda.add(new NemoMuda(x,y));
                                            aquarium[y][x] = "i";
                                            break;
                                        }
                                    }while(true);
                                    System.out.println("Berhasil Beli Ikan Nemo Muda!");
                                } else {
                                    System.out.println("Koin anda tidak cukup!");
                                }
                            }
                            else if (menu == 2) {
                                // NEMO DEWASA
                                if (active.getKoin() >= 20) {
                                    active.setKoin(active.getKoin()-20);
                                    do{
                                        x = rnd.nextInt(23)+1;
                                        y = rnd.nextInt(5)+1;
                                        if (aquarium[y][x].equals(" ")) {
                                            active.nemodewasa.add(new NemoDewasa(x,y));
                                            aquarium[y][x] = "I";
                                            break;
                                        }
                                    }while(true);
                                    System.out.println("Berhasil Beli Ikan Nemo Dewasa!");
                                } else {
                                    System.out.println("Koin anda tidak cukup!");
                                }
                            }
                            else if (menu == 3) {
                                // IBU NEMO
                                if (active.getKoin() >= 30) {
                                    active.setKoin(active.getKoin()-30);
                                    do{
                                        x = rnd.nextInt(23)+1;
                                        y = rnd.nextInt(5)+1;
                                        if (aquarium[y][x].equals(" ")) {
                                            active.ibunemo.add(new IbuNemo(x,y));
                                            aquarium[y][x] = "B";
                                            break;
                                        }
                                    }while(true);
                                    System.out.println("Berhasil Beli Ibu Ikan!");
                                } else {
                                    System.out.println("Koin anda tidak cukup!");
                                }
                            }
                            else if (menu == 0) {
                                // KEMBALI KE MENU GAME
                                break;
                            }
                        }while(true);
                    }
                    else if (choice.equals("2")) {
                        // BERI MAKAN
                        do{
                            System.out.println("========Beri Makan========");
                            active.beriMakanikan();
                            System.out.println("0. Exit");
                            System.out.println("==========================");
                            System.out.println("Koin : "+active.getKoin()+" Koin");
                            System.out.print(">> ");
                            int pilih = scanint.nextInt();
                            if (pilih == 0) {
                                // EXIT
                                break;
                            } else {
                                if (active.getKoin() >= active.getFoodlevel()) {
                                    if (pilih > active.getJumlahnemomuda()) {
                                        pilih -= active.getJumlahnemomuda();
                                        if (pilih > active.getJumlahnemodewasa()) {
                                            pilih-= active.getJumlahnemodewasa();
                                            if (pilih > active.getJumlahibunemo()) {
                                                System.out.println("Jumlah inputan melebihi jumlah ikan yang ada");
                                            } else {
                                                pilih--;
                                                active.setKoin(active.getKoin()-active.getFoodlevel());
                                                active.ibunemo.get(pilih).setCtrmakan(active.ibunemo.get(pilih).getCtrmakan()+active.getFoodlevel());
                                                active.ibunemo.get(pilih).setHp(active.ibunemo.get(pilih).getHp()+active.getFoodlevel());
                                                if (active.ibunemo.get(pilih).getHp() > 15) {
                                                    active.ibunemo.get(pilih).setHp(15);
                                                }
                                                System.out.println("Ibu Ikan ("+active.ibunemo.get(pilih).getX()+","+active.ibunemo.get(pilih).getY()+") berhasil diberi makan!");
                                            }
                                        } else {
                                            pilih--;
                                            active.setKoin(active.getKoin()-active.getFoodlevel());
                                            active.nemodewasa.get(pilih).setCtrmakan(active.nemodewasa.get(pilih).getCtrmakan()+active.getFoodlevel());
                                            active.nemodewasa.get(pilih).setHp(active.nemodewasa.get(pilih).getHp()+active.getFoodlevel());
                                            if (active.nemodewasa.get(pilih).getHp() > 20) {
                                                active.nemodewasa.get(pilih).setHp(20);
                                            }
                                            System.out.println("Ikan Nemo Dewasa ("+active.nemodewasa.get(pilih).getX()+","+active.nemodewasa.get(pilih).getY()+") berhasil diberi makan!");
                                        }
                                    } else {
                                        pilih--;
                                        active.setKoin(active.getKoin()-active.getFoodlevel());
                                        active.nemomuda.get(pilih).setCtrmakan(active.nemomuda.get(pilih).getCtrmakan()+active.getFoodlevel());
                                        active.nemomuda.get(pilih).setHp(active.nemomuda.get(pilih).getHp()+active.getFoodlevel());
                                        if (active.nemomuda.get(pilih).getHp() > 10) {
                                            active.nemomuda.get(pilih).setHp(10);
                                        }
                                        System.out.println("Ikan Nemo Muda ("+active.nemomuda.get(pilih).getX()+","+active.nemomuda.get(pilih).getY()+") berhasil diberi makan!");
                                    }
                                } else {
                                    System.out.println("Jumlah koin tidak mencukupi");
                                }
                            }
                        }while(true);
                    }
                    else if (choice.equals("3")) {
                        // AMBIL KOIN
                        System.out.println("========Ambil Koin=======");
                        if (koin.size() == 0) {
                            System.out.println("Tidak ada koin saat ini!");
                            System.out.println("=========================");
                        } else {
                            for (KoinIkan k : koin) {
                                System.out.println((koin.indexOf(k)+1)+". "+"("+k.getSimbol()+") - ("+k.getX()+","+k.getY()+")");
                            }
                            System.out.println("=========================");
                            System.out.print("Input Koordinat X: ");
                            x = scanint.nextInt();
                            System.out.print("Input Koordinat Y: ");
                            y = scanint.nextInt();
                            boolean ada = false;
                            if (x > 0 && x < 25 && y > 0 && y < 7) {
                                for (KoinIkan k : koin) {
                                    if (k.getX() == x && k.getY() == y) {
                                        ada = true;
                                        koin.remove(k);
                                        aquarium[y][x] = " ";
                                        if (k.getSimbol().equals("k")) {
                                            System.out.println("Berhasil Mengambil Koin (+2)!");
                                            active.setKoin(active.getKoin()+2);
                                        } else if (k.getSimbol().equals("K")) {
                                            System.out.println("Berhasil Mengambil Koin (+3)!");
                                            active.setKoin(active.getKoin()+3);
                                        }
                                        break;
                                    }
                                }
                                if (!ada) {
                                    System.out.println("Tidak ada koin");
                                }
                            } else {
                                System.out.println("Koordinat invalid!");
                            }
                        }
                    }
                    else if (choice.equals("4")) {
                        // IKAN SAYA
                        System.out.println("========Ikan Saya========");
                        active.ikanSaya();
                        System.out.println("=========================");
                    }
                    else if (choice.equals("5")) {
                        // UPGRADE SHOP
                        System.out.println("========Upgrade Shop========");
                        System.out.println("Welcome to Shop, "+active.getNama()+"!");
                        System.out.println("Koin: "+active.getKoin());
                        System.out.println("Level Makanan Sekarang : "+active.getFoodlevel());
                        System.out.println("Level Jaring Sekarang : "+active.getJaringlevel());
                        System.out.println("1. Upgrade Level Makanan");
                        System.out.println("2. Upgrade Level Jaring");
                        System.out.print(">> ");
                        int pilih = scanint.nextInt();
                        if (pilih == 1) {
                            if (active.getFoodlevel() < 3) {
                                System.out.println("Upgrade level "+(active.getFoodlevel()+1)+" makanan memerlukan 15 Koin (y/n)");
                                do{
                                    System.out.print(">> ");
                                    String pilihan = scan.nextLine();
                                    if (pilihan.equals("y")) {
                                        if (active.getKoin() >= 15) {
                                            active.setKoin(active.getKoin()-15);
                                            active.setFoodlevel(active.getFoodlevel()+1);
                                            System.out.println("Berhasil Upgrade level makanan menjadi level "+active.getFoodlevel());
                                        } else {
                                            System.out.println("Koin tidak cukup!");
                                        }
                                        break;
                                    } else if (pilihan.equals("n")) {
                                        System.out.println("Pilihan dibatalkan!");
                                        break;
                                    }
                                }while(true);
                            } else {
                                System.out.println("Level makanan sudah maksimal!");
                            }
                        } else if (pilih == 2) {
                            if (active.getJaringlevel() < 3) {
                                System.out.println("Upgrade level "+(active.getJaringlevel()+1)+" jaring memerlukan 15 Koin (y/n)");
                                do{
                                    System.out.print(">> ");
                                    String pilihan = scan.nextLine();
                                    if (pilihan.equals("y")) {
                                        if (active.getKoin() >= 15) {
                                            active.setKoin(active.getKoin()-15);
                                            active.setJaringlevel(active.getJaringlevel()+1);
                                            System.out.println("Berhasil Upgrade level jaring menjadi level "+active.getJaringlevel());
                                        } else {
                                            System.out.println("Koin tidak cukup!");
                                        }
                                        break;
                                    } else if (pilihan.equals("n")) {
                                        System.out.println("Pilihan dibatalkan!");
                                        break;
                                    }
                                }while(true);
                            } else {
                                System.out.println("Level jaring sudah maksimal!");
                            }
                        }
                    }
                    else if (choice.equals("6")) {
                        // JUAL IKAN
                        System.out.println("========Jual Ikan========");
                        active.jualIkan();
                        System.out.println("=========================");
                        System.out.print(">> ");
                        int pilih = scanint.nextInt();
                        if (pilih > active.getJumlahnemomuda()) {
                            pilih -= active.getJumlahnemomuda();
                            if (pilih > active.getJumlahnemodewasa()) {
                                pilih -= active.getJumlahnemodewasa();
                                if (pilih > active.getJumlahibunemo()) {
                                    System.out.println("Jumlah inputan melebihi jumlah ikan yang ada");
                                } else {
                                    pilih--;
                                    do{
                                        System.out.print("Apakah anda yakin menjual Ibu Ikan ("+active.ibunemo.get(pilih).getX()+","+active.ibunemo.get(pilih).getY()+") (y/n) ? ");
                                        String pilihan = scan.nextLine();
                                        if (pilihan.equals("y")) {
                                            active.setKoin(active.getKoin()+15);
                                            aquarium[active.ibunemo.get(pilih).getY()][active.ibunemo.get(pilih).getX()] = " ";
                                            active.ibunemo.remove(pilih);
                                            System.out.println("Ikan Berhasil dijual! Koin akan bertambah 15!");
                                            break;
                                        } else if (pilihan.equals("n")) {
                                            System.out.println("Pilihan dibatalkan!");
                                            break;
                                        }
                                    }while(true);
                                }
                            } else {
                                pilih--;
                                do{
                                    System.out.print("Apakah anda yakin menjual Ikan Nemo Dewasa ("+active.nemodewasa.get(pilih).getX()+","+active.nemodewasa.get(pilih).getY()+") (y/n) ? ");
                                    String pilihan = scan.nextLine();
                                    if (pilihan.equals("y")) {
                                        active.setKoin(active.getKoin()+10);
                                        aquarium[active.nemodewasa.get(pilih).getY()][active.nemodewasa.get(pilih).getX()] = " ";
                                        active.nemodewasa.remove(pilih);
                                        System.out.println("Ikan Berhasil dijual! Koin akan bertambah 10!");
                                        break;
                                    } else if (pilihan.equals("n")) {
                                        System.out.println("Pilihan dibatalkan!");
                                        break;
                                    }
                                }while(true);
                            }
                        } else {
                            pilih--;
                            do{
                                System.out.print("Apakah anda yakin menjual Ikan Nemo Muda ("+active.nemomuda.get(pilih).getX()+","+active.nemomuda.get(pilih).getY()+") (y/n) ? ");
                                String pilihan = scan.nextLine();
                                if (pilihan.equals("y")) {
                                    active.setKoin(active.getKoin()+5);
                                    aquarium[active.nemomuda.get(pilih).getY()][active.nemomuda.get(pilih).getX()] = " ";
                                    active.nemomuda.remove(pilih);
                                    System.out.println("Ikan Berhasil dijual! Koin akan bertambah 5!");
                                    break;
                                } else if (pilihan.equals("n")) {
                                    System.out.println("Pilihan dibatalkan!");
                                    break;
                                }
                            }while(true);
                        }
                    }
                    else if (choice.equals("7")) {
                        // GERAKKAN IKAN

                        // ADD USER MOVE COUNTER
                        active.setMovecounter(active.getMovecounter()+1);

                        // NEMO DEWASA
                        int i;
                        i = 0;
                        while(i != active.getJumlahnemodewasa()){
                            // + GERAK
                            active.nemodewasa.get(i).setCtrgerak(active.nemodewasa.get(i).getCtrgerak()+1);
                            // CEK KOIN DROP
                            if (active.nemodewasa.get(i).getCtrgerak() >= 5 && active.nemodewasa.get(i).getCtrmakan() >= 2) {
                                x = active.nemodewasa.get(i).getX();
                                y = active.nemodewasa.get(i).getY();
                                koin.add(new KoinIkan("K",x,y));
                                aquarium[y][x] = "K";
                                active.nemodewasa.get(i).setCtrmakan(0);
                                active.nemodewasa.get(i).setCtrgerak(0);
                            }
                            // MOVE
                            do{
                                int arah = rnd.nextInt(4);
                                x = active.nemodewasa.get(i).getX();
                                y = active.nemodewasa.get(i).getY();
                                if (arah == 0) { //W
                                    y--;
                                } else if (arah == 1) { //A
                                    x--;
                                } else if (arah == 2) { //S
                                    y++;
                                } else { //D
                                    x++;
                                }
                                if (aquarium[y][x].equals(" ") || aquarium[y][x].equals("#")) {
                                    aquarium[active.nemodewasa.get(i).getY()][active.nemodewasa.get(i).getX()] = " ";
                                    active.nemodewasa.get(i).setX(x);
                                    active.nemodewasa.get(i).setY(y);
                                    aquarium[y][x] = "I";
                                    break;
                                }
                            }while(true);
                            i++;
                        }

                        // NEMO MUDA
                        i = 0;
                        while(i != active.getJumlahnemomuda()){
                            // + GERAK
                            active.nemomuda.get(i).setCtrgerak(active.nemomuda.get(i).getCtrgerak()+1);
                            // CEK KOIN DROP
                            if (active.nemomuda.get(i).getCtrgerak() >= 4 && active.nemomuda.get(i).getCtrmakan() >= 1) {
                                x = active.nemomuda.get(i).getX();
                                y = active.nemomuda.get(i).getY();
                                koin.add(new KoinIkan("k",x,y));
                                aquarium[y][x] = "k";
                                active.nemomuda.get(i).setCtrmakan(0);
                                active.nemomuda.get(i).setCtrgerak(0);
                                active.nemomuda.get(i).setDropkoin(active.nemomuda.get(i).getDropkoin()+1);
                            }
                            //MOVE
                            do{
                                int arah = rnd.nextInt(4);
                                x = active.nemomuda.get(i).getX();
                                y = active.nemomuda.get(i).getY();
                                if (arah == 0) { //W
                                    y--;
                                } else if (arah == 1) { //A
                                    x--;
                                } else if (arah == 2) { //S
                                    y++;
                                } else { //D
                                    x++;
                                }
                                if (aquarium[y][x].equals(" ") || aquarium[y][x].equals("#")) {
                                    aquarium[active.nemomuda.get(i).getY()][active.nemomuda.get(i).getX()] = " ";
                                    active.nemomuda.get(i).setX(x);
                                    active.nemomuda.get(i).setY(y);
                                    aquarium[y][x] = "i";
                                    break;
                                }
                            }while(true);
                            // EVOLVE
                            if (active.nemomuda.get(i).getDropkoin() == 3) {
                                x = active.nemomuda.get(i).getX();
                                y = active.nemomuda.get(i).getY();
                                aquarium[y][x] = "I";
                                active.nemomuda.remove(i);
                                active.nemodewasa.add(new NemoDewasa(x,y));
                            } else {
                                i++;
                            }
                        }

                        // IBU NEMO
                        i = 0;
                        while(i != active.getJumlahibunemo()){
                            // + GERAK
                            active.ibunemo.get(i).setCtrgerak(active.ibunemo.get(i).getCtrgerak()+1);
                            // CEK ANAK DROP
                            if (active.ibunemo.get(i).getCtrgerak() >= 10 && active.ibunemo.get(i).getCtrmakan() >= 4) {
                                do {
                                    x = rnd.nextInt(23)+1;
                                    y = rnd.nextInt(5)+1;
                                    if (aquarium[y][x].equals(" ")) {
                                        active.nemomuda.add(new NemoMuda(x,y));
                                        aquarium[y][x] = "i";
                                        break;
                                    }
                                }while (true);
                                active.ibunemo.get(i).setCtrmakan(0);
                                active.ibunemo.get(i).setCtrgerak(0);
                            }
                            // MOVE
                            do {
                                int arah = rnd.nextInt(4);
                                x = active.ibunemo.get(i).getX();
                                y = active.ibunemo.get(i).getY();
                                if (arah == 0) { //W
                                    y--;
                                } else if (arah == 1) { //A
                                    x--;
                                } else if (arah == 2) { //S
                                    y++;
                                } else { //D
                                    x++;
                                }
                                if (aquarium[y][x].equals(" ") || aquarium[y][x].equals("#")) {
                                    aquarium[active.ibunemo.get(i).getY()][active.ibunemo.get(i).getX()] = " ";
                                    active.ibunemo.get(i).setX(x);
                                    active.ibunemo.get(i).setY(y);
                                    aquarium[y][x] = "B";
                                    break;
                                }
                            } while (true);
                            i++;
                        }

                        // MONSTER KECIL
                        i = 0;
                        while(i != active.getJumlahmonsterkecil()){
                            // CEK SEKITAR
                            boolean ada = false;
                            x = active.monsterkecil.get(i).getX();
                            y = active.monsterkecil.get(i).getY();
                            // KIRI ATAS
                            if (aquarium[y-1][x-1].equals("i") || aquarium[y-1][x-1].equals("I") || aquarium[y-1][x-1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y-1 == active.nemomuda.get(j).getY() && x-1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y-1 == active.nemodewasa.get(j).getY() && x-1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y-1 == active.ibunemo.get(j).getY() && x-1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // ATAS
                            if (aquarium[y-1][x].equals("i") || aquarium[y-1][x].equals("I") || aquarium[y-1][x].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y-1 == active.nemomuda.get(j).getY() && x == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y-1 == active.nemodewasa.get(j).getY() && x == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y-1 == active.ibunemo.get(j).getY() && x == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KANAN ATAS
                            if (aquarium[y-1][x+1].equals("i") || aquarium[y-1][x+1].equals("I") || aquarium[y-1][x+1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y-1 == active.nemomuda.get(j).getY() && x+1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y-1 == active.nemodewasa.get(j).getY() && x+1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y-1 == active.ibunemo.get(j).getY() && x+1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KIRI
                            if (aquarium[y][x-1].equals("i") || aquarium[y][x-1].equals("I") || aquarium[y][x-1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y == active.nemomuda.get(j).getY() && x-1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y == active.nemodewasa.get(j).getY() && x-1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y == active.ibunemo.get(j).getY() && x-1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KANAN
                            if (aquarium[y][x+1].equals("i") || aquarium[y][x+1].equals("I") || aquarium[y][x+1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y == active.nemomuda.get(j).getY() && x+1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y == active.nemodewasa.get(j).getY() && x+1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y == active.ibunemo.get(j).getY() && x+1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KIRI BAWAH
                            if (aquarium[y+1][x-1].equals("i") || aquarium[y+1][x-1].equals("I") || aquarium[y+1][x-1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y+1 == active.nemomuda.get(j).getY() && x-1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y+1 == active.nemodewasa.get(j).getY() && x-1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y+1 == active.ibunemo.get(j).getY() && x-1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // BAWAH
                            if (aquarium[y+1][x].equals("i") || aquarium[y+1][x].equals("I") || aquarium[y+1][x].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y+1 == active.nemomuda.get(j).getY() && x == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y+1 == active.nemodewasa.get(j).getY() && x == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y+1 == active.ibunemo.get(j).getY() && x == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KANAN BAWAH
                            if (aquarium[y+1][x+1].equals("i") || aquarium[y+1][x+1].equals("I") || aquarium[y+1][x+1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y+1 == active.nemomuda.get(j).getY() && x+1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y+1 == active.nemodewasa.get(j).getY() && x+1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y+1 == active.ibunemo.get(j).getY() && x+1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // MOVE
                            if (!ada) {
                                do {
                                    int arah = rnd.nextInt(4);
                                    x = active.monsterkecil.get(i).getX();
                                    y = active.monsterkecil.get(i).getY();
                                    if (arah == 0) { //W
                                        y--;
                                    } else if (arah == 1) { //A
                                        x--;
                                    } else if (arah == 2) { //S
                                        y++;
                                    } else { //D
                                        x++;
                                    }
                                    if (aquarium[y][x].equals(" ") || aquarium[y][x].equals("#")) {
                                        aquarium[active.monsterkecil.get(i).getY()][active.monsterkecil.get(i).getX()] = " ";
                                        active.monsterkecil.get(i).setX(x);
                                        active.monsterkecil.get(i).setY(y);
                                        aquarium[y][x] = "m";
                                        break;
                                    }
                                } while (true);
                            }
                            // CEK JARING
                            boolean kena = false;
                            for (int j = 0; j < jaring.size(); j++) {
                                if (jaring.get(j).getX() == active.monsterkecil.get(i).getX() && jaring.get(j).getY() == active.monsterkecil.get(i).getY()) {
                                    kena = true;
                                    jaring.remove(j);
                                    break;
                                }
                            }
                            if (kena) {
                                if (active.getJaringlevel() == 1) {
                                    active.monsterkecil.get(i).setHp(active.monsterkecil.get(i).getHp()-2);
                                } else if (active.getJaringlevel() == 2) {
                                    active.monsterkecil.get(i).setHp(active.monsterkecil.get(i).getHp()-5);
                                } else if (active.getJaringlevel() == 3) {
                                    active.monsterkecil.get(i).setHp(active.monsterkecil.get(i).getHp()-10);
                                }
                            }
                            i++;
                        }
                        
                        // MONSTER BESAR
                        i = 0;
                        while(i != active.getJumlahmonsterbesar()){
                            // CEK SEKITAR
                            boolean ada = false;
                            x = active.monsterbesar.get(i).getX();
                            y = active.monsterbesar.get(i).getY();
                            // KIRI ATAS
                            if (aquarium[y-1][x-1].equals("i") || aquarium[y-1][x-1].equals("I") || aquarium[y-1][x-1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y-1 == active.nemomuda.get(j).getY() && x-1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y-1 == active.nemodewasa.get(j).getY() && x-1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y-1 == active.ibunemo.get(j).getY() && x-1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // ATAS
                            if (aquarium[y-1][x].equals("i") || aquarium[y-1][x].equals("I") || aquarium[y-1][x].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y-1 == active.nemomuda.get(j).getY() && x == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y-1 == active.nemodewasa.get(j).getY() && x == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y-1 == active.ibunemo.get(j).getY() && x == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KANAN ATAS
                            if (aquarium[y-1][x+1].equals("i") || aquarium[y-1][x+1].equals("I") || aquarium[y-1][x+1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y-1 == active.nemomuda.get(j).getY() && x+1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y-1 == active.nemodewasa.get(j).getY() && x+1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y-1 == active.ibunemo.get(j).getY() && x+1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KIRI
                            if (aquarium[y][x-1].equals("i") || aquarium[y][x-1].equals("I") || aquarium[y][x-1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y == active.nemomuda.get(j).getY() && x-1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y == active.nemodewasa.get(j).getY() && x-1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y == active.ibunemo.get(j).getY() && x-1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KANAN
                            if (aquarium[y][x+1].equals("i") || aquarium[y][x+1].equals("I") || aquarium[y][x+1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y == active.nemomuda.get(j).getY() && x+1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y == active.nemodewasa.get(j).getY() && x+1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y == active.ibunemo.get(j).getY() && x+1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KIRI BAWAH
                            if (aquarium[y+1][x-1].equals("i") || aquarium[y+1][x-1].equals("I") || aquarium[y+1][x-1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y+1 == active.nemomuda.get(j).getY() && x-1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y+1 == active.nemodewasa.get(j).getY() && x-1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y+1 == active.ibunemo.get(j).getY() && x-1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // BAWAH
                            if (aquarium[y+1][x].equals("i") || aquarium[y+1][x].equals("I") || aquarium[y+1][x].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y+1 == active.nemomuda.get(j).getY() && x == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y+1 == active.nemodewasa.get(j).getY() && x == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y+1 == active.ibunemo.get(j).getY() && x == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // KANAN BAWAH
                            if (aquarium[y+1][x+1].equals("i") || aquarium[y+1][x+1].equals("I") || aquarium[y+1][x+1].equals("B")) {
                                ada = true;
                                for (int j = 0; j < active.getJumlahnemomuda(); j++) {
                                    if (y+1 == active.nemomuda.get(j).getY() && x+1 == active.nemomuda.get(j).getX()) {
                                        active.nemomuda.get(j).setHp(active.nemomuda.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahnemodewasa(); j++) {
                                    if (y+1 == active.nemodewasa.get(j).getY() && x+1 == active.nemodewasa.get(j).getX()) {
                                        active.nemodewasa.get(j).setHp(active.nemodewasa.get(j).getHp()-10);
                                    }
                                }
                                for (int j = 0; j < active.getJumlahibunemo(); j++) {
                                    if (y+1 == active.ibunemo.get(j).getY() && x+1 == active.ibunemo.get(j).getX()) {
                                        active.ibunemo.get(j).setHp(active.ibunemo.get(j).getHp()-10);
                                    }
                                }
                            }
                            // MOVE
                            if (!ada) {
                                do {
                                    int arah = rnd.nextInt(4);
                                    x = active.monsterbesar.get(i).getX();
                                    y = active.monsterbesar.get(i).getY();
                                    if (arah == 0) { //W
                                        y--;
                                    } else if (arah == 1) { //A
                                        x--;
                                    } else if (arah == 2) { //S
                                        y++;
                                    } else { //D
                                        x++;
                                    }
                                    if (aquarium[y][x].equals(" ") || aquarium[y][x].equals("#")) {
                                        aquarium[active.monsterbesar.get(i).getY()][active.monsterbesar.get(i).getX()] = " ";
                                        active.monsterbesar.get(i).setX(x);
                                        active.monsterbesar.get(i).setY(y);
                                        aquarium[y][x] = "M";
                                        break;
                                    }
                                } while (true);
                            }
                            // CEK JARING
                            boolean kena = false;
                            for (int j = 0; j < jaring.size(); j++) {
                                if (jaring.get(j).getX() == active.monsterbesar.get(i).getX() && jaring.get(j).getY() == active.monsterbesar.get(i).getY()) {
                                    kena = true;
                                    jaring.remove(j);
                                    break;
                                }
                            }
                            if (kena) {
                                if (active.getJaringlevel() == 1) {
                                    active.monsterbesar.get(i).setHp(active.monsterbesar.get(i).getHp()-2);
                                } else if (active.getJaringlevel() == 2) {
                                    active.monsterbesar.get(i).setHp(active.monsterbesar.get(i).getHp()-5);
                                } else if (active.getJaringlevel() == 3) {
                                    active.monsterbesar.get(i).setHp(active.monsterbesar.get(i).getHp()-10);
                                }
                            }
                            i++;
                        }
                        
                        // SPAWN MONSTER
                        if (active.getJumlahikantotal() > 3) {
                            int randomangka = rnd.nextInt(100)+1;
                            int randommonster = rnd.nextInt(2);
                            do{
                                x = rnd.nextInt(23)+1;
                                y = rnd.nextInt(5)+1;
                            }while(!aquarium[y][x].equals(" "));
                            if (active.getJaringlevel() == 1) {
                                // 15%
                                if (randomangka <= 15) {
                                    if (randommonster == 0) {
                                        active.monsterkecil.add(new MonsterKecil(x,y));
                                        aquarium[y][x] = "m";
                                    } else {
                                        active.monsterbesar.add(new MonsterBesar(x,y));
                                        aquarium[y][x] = "M";
                                    }
                                }
                            } else if (active.getJaringlevel() == 2) {
                                //35%
                                if (randomangka <= 35) {
                                    if (randommonster == 0) {
                                        active.monsterkecil.add(new MonsterKecil(x,y));
                                        aquarium[y][x] = "m";
                                    } else {
                                        active.monsterbesar.add(new MonsterBesar(x,y));
                                        aquarium[y][x] = "M";
                                    }
                                }
                            } else if (active.getJaringlevel() == 3) {
                                //40%
                                if (randomangka <= 40) {
                                    if (randommonster == 0) {
                                        active.monsterkecil.add(new MonsterKecil(x,y));
                                        aquarium[y][x] = "m";
                                    } else {
                                        active.monsterbesar.add(new MonsterBesar(x,y));
                                        aquarium[y][x] = "M";
                                    }
                                }
                            }
                        }

                        // CEK HEALTH
                            // NEMO MUDA
                        i = 0;
                        while(i != active.getJumlahnemomuda()){
                            if (active.nemomuda.get(i).getHp() <= 0) {
                                x = active.nemomuda.get(i).getX();
                                y = active.nemomuda.get(i).getY();
                                aquarium[y][x] = " ";
                                active.nemomuda.remove(i);
                            } else {
                                i++;
                            }
                        }
                            // NEMO DEWASA
                        i = 0;
                        while(i != active.getJumlahnemodewasa()){
                            if (active.nemodewasa.get(i).getHp() <= 0) {
                                x = active.nemodewasa.get(i).getX();
                                y = active.nemodewasa.get(i).getY();
                                aquarium[y][x] = " ";
                                active.nemodewasa.remove(i);
                            } else {
                                i++;
                            }
                        }
                            // IBU NEMO
                        i = 0;
                        while(i != active.getJumlahibunemo()){
                            if (active.ibunemo.get(i).getHp() <= 0) {
                                x = active.ibunemo.get(i).getX();
                                y = active.ibunemo.get(i).getY();
                                aquarium[y][x] = " ";
                                active.ibunemo.remove(i);
                            } else {
                                i++;
                            }
                        }
                            // MONSTER KECIL
                        i = 0;
                        while(i != active.getJumlahmonsterkecil()){
                            if (active.monsterkecil.get(i).getHp() <= 0) {
                                x = active.monsterkecil.get(i).getX();
                                y = active.monsterkecil.get(i).getY();
                                aquarium[y][x] = " ";
                                active.monsterkecil.remove(i);
                            } else {
                                i++;
                            }
                        }
                            // MONSTER BESAR
                        i = 0;
                        while(i != active.getJumlahmonsterbesar()){
                            if (active.monsterbesar.get(i).getHp() <= 0) {
                                x = active.monsterbesar.get(i).getX();
                                y = active.monsterbesar.get(i).getY();
                                aquarium[y][x] = " ";
                                active.monsterbesar.remove(i);
                            } else {
                                i++;
                            }
                        }
                    }
                    else if (choice.equals("8")) {
                        // BUNUH MONSTER
                        do{
                            System.out.println("========Bunuh Monster========");
                            active.listMonster();
                            System.out.println("=============================");
                            System.out.println("1. Serang");
                            System.out.println("0. Exit");
                            System.out.print(">> ");
                            int pilih = scanint.nextInt();
                            if (pilih == 1) {
                                // SERANG
                                if (active.getJumlahmonster() > 0) {
                                    System.out.print("Input Koordinat X: ");
                                    x = scanint.nextInt();
                                    System.out.print("Input Koordinat Y: ");
                                    y = scanint.nextInt();
                                    if (aquarium[y][x].equals(" ")) {
                                        jaring.add(new Jaring(x,y));
                                        aquarium[y][x] = "#";
                                    } else {
                                        System.out.println("Tempat ini sudah terisi");
                                    }
                                } else {
                                    System.out.println("Tidak ada monster");
                                }
                            } else if (pilih == 0) {
                                // EXIT
                                break;
                            }
                        }while(true);
                    }
                    else if (choice.equals("0")) {
                        //EXIT GAME
                        active.setScore(
                                active.getKoin()+
                                active.getJumlahnemomuda()*10+
                                active.getJumlahnemodewasa()*20+
                                active.getJumlahibunemo()*30+
                                active.getMovecounter()
                        );
                        break;
                    }
                    else if (choice.equals("money")) {
                        // CHEAT +100 KOIN
                        active.setKoin(active.getKoin() + 100);
                        System.out.println("Berhasil menambahkan 100 koin");
                    }
                }while(true);
            }
            else if (menu == 2) {
                User temp;
                // HIGHSCORE
                ArrayList<User> leaderboard = new ArrayList<>();
                // FILL LEADERBOARD WITH USER
                for (User u : user) {
                    leaderboard.add(new User(u.getNama(),u.getScore()));
                }
                // SORT LEADERBOARD
                for (int i = 0; i < leaderboard.size(); i++) {
                    for (int j = i+1; j < leaderboard.size(); j++) {
                        if (leaderboard.get(i).getScore() < leaderboard.get(j).getScore()) {
                            temp = new User(leaderboard.get(i).getNama(),leaderboard.get(i).getScore());
                            leaderboard.set(i, leaderboard.get(j));
                            leaderboard.set(j, temp);
                        }
                    }
                }
                // PRINT
                System.out.println("========Highscore========");
                if (user.size() > 0) {
                    for (int i = 0; i < leaderboard.size(); i++) {
                        System.out.println((i+1)+". "+leaderboard.get(i).getNama()+" - "+leaderboard.get(i).getScore());
                    }
                } else {
                    System.out.println("Tidak ada score saat ini!");
                }
                System.out.println("=========================");
            }
            else if (menu == 3) {
                // EXIT
                break;
            }
        }while(true);
    }
}
