# praktikum-pbo-m4

## Praktikum PBO M4

### Materi

Buatlah Program Sistem Rental DVD Sederhana 🤷‍♂️

```
======Rental XXI======
Username: admin
Password: admin
Welcome Admin!

======Rental XXI======
Username: chen
Password: bruh
Welcome chen!
```

Pada awal program mintalah user untuk menginputkan username dan password. Apabila user menginputkan “admin” pada username dan password maka pindahkan ke Menu Admin. Jika username tidak terdaftar berilah pesan error “User tidak terdaftar”. Berilah pesan “Password Salah” apabila username terdaftar tetapi password yang di masukkan salah. Jika username dan password terdaftar maka berilah pesan “User berhasil login!” dan munculkan tampilan menu awal user.

Admin

```
======Rental XXI======
======Menu Admin======
Welcome, Admin!
1. Register Customer
2. Register Employee
3. Add Movie
4. List Movie
5. List All User
6. Isi Saldo Customer
7. Exit Menu
>>
```

Register Customer\
Pada menu ini admin diminta inputan untuk register suatu customer seperti contoh dibawah. Pastikan username tiap user (customer & employee) itu unique, jika admin memasukan username yang sudah terpakai maka berilah pesan error “Username is already used!”. Customer pada awalnya memiliki default saldo sebesar 1000000. Berilah pesan berhasil apabila customer berhasil didaftarkan. Setelah customer berhasil didaftarkan maka kembalikan user ke menu utama.

```
======Register Customer======
Username: chen
Password: bruh
Username is already used!
Username: jasong
Password: jasongg
Customer berhasil didaftarkan!
```

Register Employee\
Pada menu ini admin diminta inputan untuk register suatu employee seperti contoh dibawah. Pastikan username tiap user (customer & employee) itu unique, jika admin memasukan username yang sudah terpakai maka berilah pesan error “Username is already used!”. Setelah employee berhasil didaftarkan maka kembalikan user ke menu utama.

```
======Register Employee======
Username: jasong
Password: jasongg
Username is already used!
Username: david
Password: disini
Employee berhasil didaftarkan!
```

Add Movie\
Pada menu ini admin diminta untuk menginputkan untuk menambahkan movie(film).

```
======Add Movie======
Movie Name: Revengers First Game
Movie Maker: Williandy Renatta
Type: Free
"Revengers First Game" Movie (MRF001) has successfully been added!

======Add Movie======
Movie Name: Valorant the Movie
Movie Maker: Nickolas H.
Type: Paid
Price: 15000 / hari
"Valorant the Movie" Movie (MVT001) has successfully been added!
```

Pada bagian input “Type” admin hanya akan bisa menginputkan “Free” atau “Paid”. Berilah juga pesan error apabila price yang diinputkan itu kurang dari 0. Untuk setiap movie yang dibuat berilah ID dengan format (M - <2 Huruf > - Index). 2 Huruf dalam format akan berdasarkan jumlah kata dari nama aplikasi. Apabila jumlah kata >1 maka yang dipakai adalah huruf pertama dari dua kata pertama. Jika kata kurang dari 2 maka gunakan 2 huruf pertama dari kata tersebut.

List User\
Pada menu ini tampilkan semua user yang sudah di add oleh admin. Format untuk list user adalah username – password.

```
======List User======
1. chen - bruh
2. jasong - jasongg
3. widean - widd
```

List Movie\
Pada menu ini tampilkan semua movie yang sudah terdaftar oleh admin. Format untuk list user adalah movie id - nama movie – maker - type.

```
======List Movie======
1. MRF001 - Revengers First Game - Williandy Renatta - Free
2. MVT001 -Valorant the Movie - Nickolas H. - Paid
```

Isi Saldo User\
Pada menu ini tampilkan list user kemudian admin akan memilih user mana yang mau diisi saldo. Kemudian admin akan menginputkan nominal yang ingin diisi. Apabila nominal ≤ 0 maka berilah pesan error. Setelah berhasil mengisi saldo maka kembalikan admin ke Menu Admin.

```
======Isi Saldo======
1. chen
2. jasong
3. widean
>> 1
Masukkan Saldo: -100
Invalid Input!
Masukkan Saldo: 10000
Berhasil isi saldo!
```

Exit Menu\
Apabila user memilih menu ini, maka kembalikan admin ke menu login.

Customer

```
======Rental XXI======
======Menu Customer======
Welcome, chen!
Saldo : 1000000
1. Rental Movie
2. Kembalikan Movie
3. My Movies
4. Exit Menu
```

Rental Movie\
Pada menu ini tampilkan semua list movie yang telah di add oleh admin (Movie yang ditampilkan itu semua movie jadi belum di rental dan sudah di rental). Customer diminta untuk memilih movie yang ingin dirental olehnya. Apabila movie yang dipilih customer adalah tipe berbayar (paid) maka berilah pengecekan apakah saldo milik customer mencukupi. Setelah customer memilih maka inputlah berapa hari customer ingin me-rental movie tersebut. Movie akan berhasil dirental apabila employee menyetujui rental tersebut.

```
======Rental Movie======
1. MRF001 - Revengers First Game - Williandy Renatta - Free
2. MVT001 - Valorant the Movie - Nickolas H. - Paid
3. MAE001 - Avengers: End Game - Nickolas S. - Paid
4. MQG001 - Queen's Gambit - Lawrence P - Free
5. MHE001 - HelloWorld - Lawrence S - Free
>> 2
Masukkan hari : 100
Saldo tidak cukup!
>> 1
Masukkan hari : 5
Berhasil! Rental akan di proses oleh employee!
```

Kembalikan Movie\
Pada menu ini customer dapat mengembalikan movie yang telah dipinjam dengan format sebagai berikut.

```
======Kembalikan Movie======
1. MRF001 - Revengers First Game - 5 hari
2. MQG001 - Queen's Gambit - 5 Hari
3. MHE001 - HelloWorld - 2 Hari
>> 1
Movie berhasil dikembalikan!
```

Setelah customer mengambalikan movie maka movie akan bisa dipinjam lagi oleh customer lain.

My Movies\
Pada menu ini tampilkan semua movie yang sedang di rental oleh customer. Format penulisan untuk menu ini adalah movie id - nama movie – jumlah hari rental

```
======My Movies======
1. MQG001 - Queen's Gambit - 5 Hari
2. MHE001 - HelloWorld - 2 Hari
```

Exit Menu\
Apabila user memilih menu ini, maka kembalikan customer ke menu login.

Employee

```
======Rental XXI======
======Menu Employee======
Welcome, jasong!
1. Accept Rental
2. List Movie
3. Exit Menu
>>
```

Accept Rental\
Pada menu ini tampilkan semua request rental movie yang di request oleh customer.

```
======Accept Rental======
1. Revengers First Game - 5 hari - chen
2. Valorant the Movie - 2 hari - david
3. Avengers: End Game - 100 hari - chen
>> 3
Apakah disetujui (y/n)? n
Rental Avengers: End Game - chen telah ditolak
======Accept Rental======
1. Revengers First Game - 5 hari - chen
2. Valorant the Movie - 2 hari - david
3. Avengers: End Game - 100 hari - chen
>> 2
Apakah disetujui (y/n)? y
Rental Valorant the Movie - david telah diterima
```

Mintalah inputan kepada employee untuk memilih request rental di dalam list. Setelah memilih request maka employee akan diminta untuk menginputkan y/n untuk yes dan no. Input “y” akan menyetujui request rental milik customer sedangkan input “n” untuk menolak request rental. Apabila employee telah menyetujui request rental maka tambahlah movie ke dalam “My Movies” di menu customer dan jika movie merupakan tipe yang berbayar maka kurangilah saldo customer sebanyak harga per hari \* hari pinjam. Berilah pengecekan apabila tersedia ketersediaan movie tersebut dan beri pesan error apabila movie tersebut masih di rental. Pada accept rental terdapat suatu fitur “auto decline”, jadi pada saat employee menyetujui suatu request maka movie yang sama pada request movie yang lain akan ter-decline (Fitur auto decline akan berjalan hanya pada saat employee accept rental pada suatu movie). Sedangkan apabila employee mendapatkan request movie yang sama maka employee akan menolak request movie secara manual.

List Movie\
Pada menu ini tampilkan semua movie beserta status ketersediaan yang ada dan dicetak dengan format seperti berikut.

```
======List Movie======
1. Revengers First Game - Belum dipinjam
2. Valorant the Movie - Dipinjam oleh david
3. Avengers: End Game - Belum dipinjam
4. Queen's Gambit - Dipinjam oleh chen
5. HelloWorld - Belum dipinjam
```

Exit menu\
Apabila user memilih menu ini, maka kembalikan employee ke menu login

### Tugas

Buatlah game Insaniquarium Sederhana ><(((º> 🦈🍅 <º)))><

```
======================
|            <º)))>< |
|                    |
|  <Insaniquarium>   |
|            <Game>  |
| ><(((º>            |
|                    |
======================
-------Main Menu-------
1. Play Game
2. Highscore
3. Exit
```

Play Game\
Mulailah game dengan meminta player untuk menginputkan nama. Setelah menginputkan nama tampilkan map beserta menunya. Pada awal permainan player hanya akan memiliki 1 ibu ikan dan 1 ikan nemo kecil yang di random tempat spawnnya. Ukuran map adalah 25 x 7 (termasuk border).

```
Tampilan Pertama
B
i
=========================
|            B          |
|                       |
|                       |
| i                     |
|                       |
=========================
========Menu Game========
Koin : 10
1. Beli Ikan
2. Beri Makan
3. Ambil Koin
4. Ikan Saya
5. Upgrade Shop
6. Jual Ikan
7. Gerakkan Ikan
0. Surrender
>>
```

Beli Ikan\
Pada menu ini tampilkan menu yang menampilkan list jenis ikan beserta harganya. Player dapat membeli ikan sesuai dengan input player. Apabila player tidak memiki koin yang cukup untuk membeli ikan tersebut maka berilah pesan error. Berilah pesan berhasil apabila player memiliki koin yang cukup. Kemudian ikan yang dibeli akan spawn dengan koordinat random di map game. Ikan memiliki jenis-jenis tertentu yang akan dijelaskan dibawah

```
========Beli Ikan========
Koin : 20 Koin
1. Ikan Nemo Muda (10 Koin) - (Total:1)
2. Ikan Nemo Dewasa (20 Koin) - (Total:0)
3. Ibu Ikan (30 Koin) - (Total:1)
0. Kembali ke Menu Game
>> 1
Berhasil Beli Ikan Nemo Muda!
========Beli Ikan========
Koin : 10 Koin
1. Ikan Nemo Muda (10 Koin) - (Total:2)
2. Ikan Nemo Dewasa (20 Koin) - (Total:0)
3. Ibu Ikan (30 Koin) - (Total:1)
0. Kembali ke Menu Game
>> 2
Koin anda tidak cukup!
```

Jenis - Jenis Ikan:

| Jenis Ikan         | Keterangan                                                                                                                                                                                                                                                                                                                      | Simbol Map | Simbol Koin | HP Ikan |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------- | ----------- | ------- |
| Ikan Nemo Muda     | - Setiap ikan ini bergerak sebanyak 4x dan diberi makan 1x maka ikan ini akan menjatuhkan “k”. 1 “k” = 2 Koin <br> - Setiap kali ikan ini menjatuhkan koin, maka resetlah counter makan dan reset counter gerak ikan. <br> - Apabila ikan ini sudah menjatuhkan “k” sebanyak 3x maka ubahlah ikan ini menjadi Ikan Nemo Dewasa. | i          | k           | 10      |
| Ikan Nemo Dewasa   | - Setiap ikan ini bergerak sebanyak 5x dan diberi makan 2x maka ikan ini akan menjatuhkan “K”. 1 “K” = 3 Koin <br> - Setiap kali ikan ini menjatuhkan koin, maka resetlah counter makan dan reset counter gerak ikan.                                                                                                           | I          | K           | 20      |
| Ibu Ikan           | - Setiap ikan ini bergerak sebanyak 10x dan diberi makan 4x maka ikan ini akan menelurkan 1 ikan nemo muda (spawn di koordinat random). <br> - Setiap kali ikan ini menelurkan ikan, maka resetlah counter makan dan reset counter gerak ikan.                                                                                  | B          | (Tidak ada) | 15      |
| Ikan Monster Kecil | Ikan ini bertujuan untuk memakan ikan selain ikan monster, ATK monster ini adalah 10 ATK                                                                                                                                                                                                                                        | m          | (Tidak ada) | 5       |
| Ikan Monster Besar | Ikan ini bertujuan untuk memakan ikan selain ikan monster, ATK monster ini adalah 20 ATK                                                                                                                                                                                                                                        | M          | (Tidak ada) | 10      |

Beri Makan\
Pada menu ini tampilkan list ikan yang ada di dalam map. Player akan memberi input untuk memilih ikan yang ingin diberi makanan. Setiap kali ikan diberi makanan maka tambahkan counter makan milik ikan sesuai level makanan ikan. HP ikan akan bertambah apabila HP milik ikan tidak maksimal saat diberi makanan. Pastikan HP ikan tidak melebihi maksimal HP ikan.

Format List Beri Makan adalah Jenis Ikan - Counter Makan - Koordinat Ikan - HP Ikan

```
========Beri Makan========
1. Ikan Nemo Muda - 0 Food - (2,4) - 10 HP
2. Ibu Ikan - 0 Food -(13,1) - 15 HP
0. Exit
==========================
Koin : 20 Koin
>> 1
Ikan Nemo Muda (2,4) berhasil diberi makan!
========Beri Makan========
1. Ikan Nemo Muda - 1 Food - (2,4) - 10 HP
2. Ibu Ikan - 0 Food -(13,1) - 15 HP
0. Exit
==========================
Koin : 19 Koin
>> 0
```

Apabila berhasil diberi makan, koin akan berkurang sesuai dengan level makanan dan counter makan akan bertambah sesuai level makanan juga.

Ambil Koin\
Pada menu ini tampilkan list koin yang terdapat pada map. Apabila pada map tidak terdapat koin maka tampilkan pesan “Tidak ada koin saat ini”. Apabila terdapat koin pada map maka tampilkan dalam bentuk list dengan format sebagai berikut

```
========Ambil Koin========
Tidak ada koin saat ini!
==========================

========Ambil Koin========
1. Koin (k) - (2,3)
2. Koin (K) - (5,5)
3. Koin (K) - (6,7)
==========================
Input Koordinat X: 2
Input Koordinat Y: 3
Berhasil Mengambil Koin (+2)!
```

Berilah pengecekan apabila X dan Y valid atau tidak. Apabila koordinat invalid (keluar dari map atau bukan koin) maka berilah pesan error. Format list adalah sebagai berikut Koin (Symbol Koin) – (x,y)

Ikan Saya\
Pada menu ini tampilkan semua ikan pada map. Contoh tampilan akan sebagai berikut.

```
========Ikan Saya========
1. Ikan Nemo Muda - 1 Food - 2 Steps - (2,4) - 10 HP
2. Ibu Ikan - 0 Food - 0 Steps - (13,1) - 15 HP
```

Format List Ikan Saya adalah Jenis Ikan - Counter Makan - Jumlah Langkah - Koordinat Ikan - HP Ikan

Upgrade Shop\
Pada menu ini tampilan menu upgrade shop seperti contoh dibawah. Menu ini digunakan untuk menaikkan level Makanan dan level Jaring player. Player akan menginputkan angka 1 atau 2 untuk memilih apa yang akan di upgrade. Apabila koin yang dimiliki cukup untuk upgrade maka kurangilah koin tersebut dan berilah pesan berhasil. Apabila koin tidak cukup atau level sudah maksimal maka berilah pesan error sesuai dengan error masing-masing.

| Jenis Upgrade | Level 1 | Level 2 | Level 3 |
| ------------- | ------- | ------- | ------- |
| Jaring        | 2 ATK   | 5 ATK   | 10 ATK  |
| Makanan       | 1 Food  | 2 Food  | 3 Food  |

Note : Koin yang diperlukan setiap upgrade adalah 15 koin.

```
========Upgrade Shop========
Welcome to Shop, Chen!
Koin: 20
Level Makanan Sekarang : 1
Level Jaring Sekarang : 1
1. Upgrade Level Makanan
2. Upgrade Level Jaring
>> 1
Upgrade level 2 makanan memerlukan 15 Koin (y/n)
>> y
Berhasil Upgrade level makanan menjadi level 2!
```

Jual Ikan\
Pada menu ini tampilkan smeua list ikan yang ada di map. Menu ini akan meminta input untuk ikan yang akan dijual. Harga ikan yang dijual akan sebesar setengah harga dari harga beli. Tampilan menu Jual Ikan akan seperti contoh dibawah.

```
========Jual Ikan========
1. Ikan Nemo Muda - (2,4)
2. Ibu Ikan - (13,1)
=========================
>> 1
Apakah anda yakin menjual Ibu Ikan (13,1) (y/n) ? y
Ikan Berhasil dijual! Koin akan bertambah 15!
```

Gerakkan Ikan\
Pada saat player memilih menu ini maka gerakkan semua ikan yang ada pada map. Gerakkan ikan selain ikan monster akan random dan tidak boleh ada yang berada pada koordinat yang sama alias tidak bertubrukkan. Pastikan setiap ikan tidak keluar dari map saat gerakkannya terandom. Kemudian tambahkan jumlah langkah pada masing-masing ikan dan berilah pengecekan apakah ikan dapat menjatuhkan koin atau tidak.

Bunuh Monster (Menu S)

```
=========================
|m                  M   |
|        I              |
|                       |
|          i            |
|      B                |
=========================
========Menu Game========
!!! MONSTER DALAM MAP !!!
Koin : 10
1. Beli Ikan
2. Beri Makan
3. Ambil Koin
4. Ikan Saya
5. Upgrade Shop
6. Jual Ikan
7. Gerakkan Ikan
8. Bunuh Monster
0. Surrender
>> 8
========Bunuh Monster========
1. Ikan Monster (M) - (20,1) - 5 HP
2. Ikan Monster (m) - (1,1) - 10 HP
=============================
1. Serang
0. Exit
>> 1
Input Koordinat X:1
Input Koordinat Y:2
Berhasil memasang jaring!

=========================
|m#                 M   |
|        I              |
|                       |
|          i            |
|      B                |
=========================
========Menu Game========
!!! MONSTER DALAM MAP !!!
Koin : 10
1. Beli Ikan
2. Beri Makan
3. Ambil Koin
4. Ikan Saya
5. Upgrade Shop
6. Jual Ikan
7. Gerakkan Ikan
8. Bunuh Monster
0. Surrender
>>
```

Pada menu ini adalah menu special yang akan keluar apabila terdapat monster dalam map. Selain menampilkan menu baru ini, tampilkan juga notifikasi “Monster dalam Map”. Cara player membunuh monster adalah dengan cara meletakkan jaring di map. Apabila monster bergerak ke koordinat jaring maka kurangilah hp monster bedasarkan level jaring sekarang. Berilah juga pengecekan apabila koordinat yang diinput valid atau tidak. Format menu bunuh monster adalah sebagai berikut Ikan Monster (tipe monster) - (x,y) - jumlah HP

Surrender\
Apabila Player memilih menu ini maka akhirilah game dan hitung score player dan masukkan score player ke highscore. Kemudian kembalikan player ke main menu awal.

Highscore\
Pada menu ini tampilkan semua yang pernah bermain game ini kemudian urutkan dari score tertinggi ke terendah. Tampilan menu akan seperti contoh dibawah ini.

```
========Highscore========
1. Jasong - 100
2. Widean - 40
3. Chen - 20
=========================
```

Format: Nama Player - Score

Rules

```
=========================
|m#                 M   |
|        I              |
|                       |
| K        i        k   |
|      B                |
=========================
B = Ibu Ikan
I = Ikan Nemo Dewasa
i = Ikan Nemo Muda
M = Ikan Monter Besar
m = Ikan Monster Kecil
# = Jaring
```

Sistem Pergerakan:

-   Pergerakkan semua ikan di map akan random (semua arah) dan akan bergerak sekali apabila player memilih menu gerakkan ikan.
-   Apabila tidak ingin mendapatkan +2 poin maka pergerakkan Ikan monster akan sama seperti ikan lainnya (random semua arah)
-   Apabila ingin mendapatkan +2 poin untuk pergerakkan ikan monster, maka sistem gerak monster akan seperti berikut.
    -   Setelah monster spawn, carilah ikan terdekat (selain ikan monster)
    -   Kemudian Ikan monster akan target ikan terdekat dengan spawn ikan monster tersebut.
    -   Apabila Ikan yang ditarget sudah mati maka ikan monster akan target ikan terdekat dari koordinatnya.
-   Pastikan untuk pergerakkan ikan tidak bisa saling menubruk antara sesama ikan. Entity yang dapat tertabrak hanya koin atau jaring saja.

Sistem Attack Monster:

-   Cara monster memakan ikan adalah dengan cara melihat koordinat milik ikan lain. Apabila terdapat ikan disekitar maka kurangilah HP ikan sesuai attack ikan monster.

Contoh:
X: Jangkauan makan Ikan Monster
M: Ikan Monster

|     |     |     |
| --- | --- | --- |
| X   | X   | X   |
| X   | M   | X   |
| X   | X   | X   |

Sistem Spawn Monster:

-   Monster akan spawn apabila jumlah ikan sudah lebih dari 3 dan persentase untuk spawn monster bergantung pada level jaring yang dimiliki player. Jika level jaring 1 maka spawn rate adalah 15%, jika level jaring 2 maka spawn rate adalah 35%, kemudian 40% untuk level jaring 3.
-   Kapan sebuah monster spawn? Monster akan spawn pada saat player memiliki total lebih dari 3 ikan dan akan spawn saat player memilih menu gerakkan ikan (dipengaruhi dengan spawn rate juga).

Sistem Scoring

-   Aturan scoring pada game ini berdasarkan total koin sekarang + jumlah ikan \* harga ikan (sesuai jenis) + jumlah Langkah (Jumlah player memilih menu “Gerakkan Ikan”).

CHEATS (WAJIB DIKERJAKAN)

-   Apabila user input “money” saat game berlangsung maka tambahkan 100 koin kepada player.

Exit\
Menu ini digunakan untuk exit.
