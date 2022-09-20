import java.util.Scanner;
public class Uas{
    static String buku[] = {"Laskar Pelangi", "Negeri 5 Menara", "Laut Bercerita",  "Dilan 1990", "Marmut Merah Jambu"};
    static String pengarang[] = {"Andrea Hirata", "Ahmad Fuadi", "Leila Salikha Chudori", "Pidi Baiq", "Raditya Dika"};
    static int tahun[] = {2005, 2009, 2017, 2014, 2010};
    static int stok[] = {25, 20, 20, 10, 25};
    static int kode[] = {1, 2, 3, 4, 5};
    static String rak[] = {"Rak Buku 1", "Rak Buku 2", "Rak Buku 3", "Rak Buku 4", "Rak Buku 5"};
    static int peminjam = 0;
    static int idPeminjam[] = new int[100];
    static int bukuPinjam = 0;
    static int pinjamBuku[] = new int[100];
    static int banyakBuku = 0;
    static int jumlahBuku[] = new int[100];
    static int waktuPinjam = 0;
    static int lamaPinjam[] = new int[100];
    static int tanggal = 0;
    static String tanggalPinjam[] = new String[100];

    public static void daftarMenu(){
        Scanner input = new Scanner(System.in);
        int menu;
        System.out.println("\n=========================");
        System.out.println("        Daftar Menu");
        System.out.println("=========================");
        System.out.println("1. Daftar Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Perpanjang Pinjam Buku");
        System.out.println("5. Pencarian Buku");
        System.out.println("6. Riwayat Peminjaman");
        System.out.println("7. Close Program");
        System.out.println("------------------------------------");
        System.out.print("Pilih Menu (1, 2, 3, 4, 5, 6, 7): ");
        menu = input.nextInt();
        switch(menu){
            case 1:
            dataBarang();
            break;
            case 2:
            inputPeminjaman();
            break;
            case 3:
            inputPengembalian();
            break;
            case 4:
            perpanjangan();
            break;
            case 5:
            pencarian();
            break;
            case 6:
            riwayat();
            break;
            default:
            break;
        }
    }

    public static void dataBarang(){
        System.out.println("\n=================================================================");
        System.out.println("                        Daftar Buku");
        System.out.println("=================================================================");
        System.out.println("Kode\t    Judul\t\t  Pengarang\t\t Stok");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" " + kode[0] + "\t" + buku[0] + "\t\t" + pengarang[0] + "\t\t  " + stok[0]);
        System.out.println(" " + kode[1] + "\t" + buku[1] + "\t\t" + pengarang[1] + "\t\t  " + stok[1]);
        System.out.println(" " + kode[2] + "\t" + buku[2] + "\t\t" + pengarang[2] + "\t  " + stok[2]);
        System.out.println(" " + kode[3] + "\t" + buku[3] + "\t\t" + pengarang[3] + "\t\t  " + stok[3]);
        System.out.println(" " + kode[4] + "\t" + buku[4] + "\t" + pengarang[4] + "\t\t  " + stok[4]);
        perulanganProgram();
    }

    public static void perulanganProgram(){
        Scanner input = new Scanner(System.in);
        char ulang;
        System.out.print("\nApakah Ingin Kembali Ke Menu Utama (y/n)? ");
        ulang = input.next().charAt(0);
        switch(ulang){
            case 'y':
            daftarMenu();
            break;
            case 'Y':
            daftarMenu();
            break;
            default:
            break;
        }
    }
   
    public static void inputPeminjaman(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n=========================================================");
        System.out.println("                    Menu Pinjam Buku");
        System.out.println("=========================================================");
        char pinjamLagi = 'y';
        while(pinjamLagi == 'y' || pinjamLagi == 'Y'){
            System.out.print("Masukkan Nomor ID Peminjam Buku: ");
            idPeminjam[peminjam] = input.nextInt();
            System.out.print("Masukkan Kode Buku Yang Ingin Dipinjam: ");
            pinjamBuku[bukuPinjam] = input.nextInt();
            System.out.print("Masukkan Jumlah Buku Yang Ingin Dipinjam: ");
            jumlahBuku[banyakBuku] = input.nextInt();
            System.out.print("Berapa Hari Buku Dipinjam? ");
            lamaPinjam[waktuPinjam] = input.nextInt();
            input.nextLine();
            System.out.print("Masukkan Tanggal Peminjaman (ex: 31-12-2021): ");
            tanggalPinjam[tanggal] = input.nextLine();
            for(int i = 0; i < 5; i++){
                if(pinjamBuku[bukuPinjam] == kode[i]){
                    if(stok[i] > 0){
                    stok[i] -= jumlahBuku[banyakBuku];
                        if(stok[i] < 0){
                            stok[i] += jumlahBuku[banyakBuku];
                            System.out.println("Peminjaman Dibatalkan Karena Stok Buku Tidak Cukup!");
                            break;
                        }else{
                            System.out.println("Judul Buku Yang Dipinjam: " + buku[i]);
                            System.out.println("Pengarang: " + pengarang[i]);
                            biayaPinjam();
                            break;
                        }
                    }else{
                        System.out.println("Stok Buku Habis!");
                        break;
                    }
                }
            }
            if(pinjamBuku[bukuPinjam] > 5){
                System.out.println("Kode Buku Yang Dimasukkan Salah!");
            }
            peminjam++;
            banyakBuku++;
            bukuPinjam++;
            waktuPinjam++;
            tanggal++;
            System.out.println("------------------------------------------------");
            System.out.print("Apakah Ada Yang Ingin Pinjam Buku Lagi (y/n)? ");
            pinjamLagi = input.next().charAt(0);
            System.out.println("------------------------------------------------");
        }
        perulanganProgram();
    }

    public static void biayaPinjam(){
        int biaya;
        biaya = kasirPinjam(jumlahBuku[banyakBuku], lamaPinjam[waktuPinjam]);
        System.out.println("Biaya Pinjam Rp." + biaya);
    }

    public static int kasirPinjam(int jumlah, int durasi){
        int tagihanPinjam;
        tagihanPinjam = 2000 * jumlah * durasi;
        return tagihanPinjam;
    }

    public static void inputPengembalian(){
        Scanner input = new Scanner(System.in);
        int pengembalian, bukuKembali, jumlahKembali, lamaTelat, denda;
        System.out.println("\n=========================================================");
        System.out.println("                    Menu Kembalikan Buku");
        System.out.println("=========================================================");
        char telat, kembalikanLagi = 'y';
        while(kembalikanLagi == 'y' || kembalikanLagi == 'Y'){
            System.out.print("Masukkan Nomor ID Peminjam Buku: ");
            pengembalian = input.nextInt();
            System.out.print("Masukkan Kode Buku Yang Ingin Dikembalikan: ");
            bukuKembali = input.nextInt();
            System.out.print("Masukkan Jumlah Buku Yang Ingin Dikembalikan: ");
            jumlahKembali = input.nextInt();
            for(int i = 0; i < 5; i++){
                if(bukuKembali == kode[i]){
                    System.out.println("Judul Buku Yang Dipinjam: " + buku[i]);
                    stok[i] += jumlahKembali;
                    break;
                }
            }
            if(bukuKembali > 5){
                System.out.println("Kode Buku Yang Dimasukkan Salah!");
            }
            for(int j = 0; j <= 100; j++){
                if(j == 100){
                    System.out.println("Data Peminjaman Tidak Ditemukan!");
                    break;
                }
                if(pengembalian == idPeminjam[j] && bukuKembali == pinjamBuku[j]){
                    System.out.println("Jumlah Buku Yang Dipinjam: " + jumlahBuku[j]);
                    System.out.println("Lama Hari Buku Yang Dipinjam: " + lamaPinjam[j]);
                    System.out.println("Tanggal Buku Yang Dipinjam: " + tanggalPinjam[j]);
                    if(jumlahKembali > jumlahBuku[j]){
                        System.out.println("Pengembalian Dibatalkan Karena Jumlah Buku Yang Dikembalikan Kelebihan!");
                        break;
                    }else{
                        jumlahBuku[j] -= jumlahKembali;
                        System.out.print("Apakah Telat Mengembalikan (y/n)? ");
                        telat = input.next().charAt(0);
                        if(telat == 'y' || telat == 'Y'){
                            System.out.print("Berapa Hari Telat Mengembalikan? ");
                            lamaTelat = input.nextInt();
                            denda = biayaDenda(lamaTelat, jumlahKembali);
                            System.out.println("Denda: Rp." + denda);
                            break;
                        }
                        break;      
                    }  
                }
            }
            System.out.println("---------------------------------------------------------");
            System.out.print("Apakah Ada Peminjam Ingin Kembalikan Buku Lagi (y/n)? ");
            kembalikanLagi = input.next().charAt(0);
            System.out.println("---------------------------------------------------------");
        }
        perulanganProgram();
    }

    public static int biayaDenda(int durasiTelat, int jumlahTelat){
        int tagihanDenda;
        tagihanDenda = 5000 * durasiTelat * jumlahTelat;
        return tagihanDenda;
    }

    public static void perpanjangan(){
        Scanner input = new Scanner(System.in);
        int pemerpanjang, bukuPerpanjang, lamaPerpanjangan, bayarPerpanjang;
        System.out.println("\n=========================================================");
        System.out.println("               Menu Perpanjangan Pinjam Buku");
        System.out.println("=========================================================");
        char perpanjanganLagi = 'y';
        while(perpanjanganLagi == 'y' || perpanjanganLagi == 'Y'){
            System.out.print("Masukkan Nomor ID Peminjam Buku: ");
            pemerpanjang = input.nextInt();
            System.out.print("Masukkan Kode Buku Yang Ingin Diperpanjang: ");
            bukuPerpanjang = input.nextInt();
            for(int i = 0; i < 5; i++){
                if(bukuPerpanjang == kode[i]){
                    System.out.println("Judul Buku Yang Dipinjam: " + buku[i]);
                    break;
                }
            }
            if(bukuPerpanjang > 5){
                System.out.println("Kode Buku Yang Dimasukkan Salah!");
            }
            for(int j = 0; j <= 100; j++){
                if(j == 100){
                    System.out.println("Data Peminjaman Tidak Ditemukan!");
                    break;
                }
                if(pemerpanjang == idPeminjam[j] && bukuPerpanjang == pinjamBuku[j]){
                System.out.println("Jumlah Buku Yang Dipinjam: " + jumlahBuku[j]);
                System.out.println("Lama Hari Buku Yang Dipinjam: " + lamaPinjam[j]);
                System.out.println("Tanggal Buku Yang Dipinjam: " + tanggalPinjam[j]);
                if(jumlahBuku[j] == 0){
                    System.out.println("Perpanjangan Dibatalkan Karena Tidak Ada Buku Yang Dipinjam");
                    break;
                }
                System.out.print("Perpanjang Pinjam Buku Berapa Hari? ");
                lamaPerpanjangan = input.nextInt();
                lamaPinjam[j] += lamaPerpanjangan;
                bayarPerpanjang = biayaPerpanjangan(lamaPerpanjangan, jumlahBuku[j]);
                System.out.println("Biaya Perpanjangan: Rp." + bayarPerpanjang);
                break;
                }
            }
            System.out.println("-------------------------------------------------------------");
            System.out.print("Apakah Ada Peminjam Yang Ingin Perpanjang Buku Lagi (y/n)? ");
            perpanjanganLagi = input.next().charAt(0);
            System.out.println("-------------------------------------------------------------");
        }
        perulanganProgram();
    }

    public static int biayaPerpanjangan(int durasiPerpanjang, int jumlahPerpanjang){
        int tagihanPerpanjang;
        tagihanPerpanjang = 2000 * durasiPerpanjang * jumlahPerpanjang;
        return tagihanPerpanjang;
    }

    public static void pencarian(){
        Scanner input = new Scanner(System.in);
        int cari;
        String cariJudul, cariPengarang;
        System.out.println("\n=========================================================");
        System.out.println("                   Menu Pencarian Buku");
        System.out.println("=========================================================");
        char cariLagi = 'y';
        while(cariLagi == 'y' || cariLagi == 'Y'){
            System.out.println("1. Pencarian Berdasarkan Judul Buku");
            System.out.println("2. Pencarian Berdasarkan Pengarang Buku");
            System.out.println("------------------------------------------");
            System.out.print("Pilih Menu Pencarian (1, 2): ");
            cari = input.nextInt();
            switch(cari){
                case 1:
                System.out.print("Masukkan Judul Buku: ");
                input.nextLine();
                cariJudul = input.nextLine();
                for(int i = 0; i <= 5; i++){
                    if(i == 5){
                        System.out.println("Judul Buku Yang Dimasukkan Salah!");
                        break;
                    }
                    if(cariJudul.equalsIgnoreCase(buku[i])){
                    System.out.println("Pengarang: " + pengarang[i]);
                    System.out.println("Tahun Terbit: " + tahun[i]);
                    System.out.println("Stok Tersedia: " + stok[i]);
                    System.out.println("Letak: " + rak[i]);
                    break;
                    }
                }
                break;
                case 2:
                System.out.print("Masukkan Nama Pengarang Buku: ");
                input.nextLine();
                cariPengarang = input.nextLine();
                for(int j = 0; j <= 5; j++){
                    if(j == 5){
                        System.out.println("Nama Pengarang Buku Yang Dimasukkan Salah!");
                        break;
                    }
                    if(cariPengarang.equalsIgnoreCase(pengarang[j])){
                    System.out.println("Judul Buku: " + buku[j]);
                    System.out.println("Tahun Terbit: " + tahun[j]);
                    System.out.println("Stok Tersedia: " + stok[j]);
                    System.out.println("Letak: " + rak[j]);
                    break;
                    }
                }
                break;
                default:
                System.out.println("Menu Pencarian Tidak Tersedia!");
                break;
            }
            System.out.println("--------------------------------------------------");
            System.out.print("Apakah Ada Yang Ingin Mencari Buku Lagi (y/n)? ");
            cariLagi = input.next().charAt(0);
            System.out.println("--------------------------------------------------");
        }
        perulanganProgram();
    }

    public static void riwayat(){
        System.out.println("\n===============================================");
        System.out.println("           Riwayat Peminjaman Buku");
        System.out.println("===============================================");
        for(int i = 0; i < peminjam; i++){
            System.out.println("Nomor ID Peminjam Buku: " + idPeminjam[i]);
            System.out.println("Kode Buku Yang Dipinjam: " + pinjamBuku[i]);
            System.out.println("Jumlah Buku Yang Dipinjam: " + jumlahBuku[i]);
            System.out.println("Lama Hari Buku Yang Dipinjam: " + lamaPinjam[i]);
            System.out.println("Tanggal Buku Yang Dipinjam: " + tanggalPinjam[i]);
            System.out.println("-----------------------------------------------");
        }
        perulanganProgram();
    }

    public static void main(String[]args){
        System.out.println("=======================");
        System.out.println("PROGRAM PEMINJAMAN BUKU");
        System.out.println("----BY HILMI MUGHID----");
        daftarMenu();
    } 
}