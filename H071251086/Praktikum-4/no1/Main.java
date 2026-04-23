package tuprak4.no1;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------");
        System.out.println("====== BANGUN RUANG ======");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");

        System.out.println("\n====== BANGUN DATAR ======");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("----------------------------------");

        System.out.println("\nPilihan : ");
        int pilih = input.nextInt();
        System.out.println("----------------------------------");

        switch(pilih){
            case 1 :
                System.out.print("Masukkan sisi kubus : ");
                int sisi = input.nextInt();

                Kubus kubus1 = new Kubus(sisi);
                kubus1.menghitungLuas();
                kubus1.menghitungVolume();
            break;

            case 2 :
                System.out.print("Masukkan panjang balok : ");
                int panjang = input.nextInt();

                System.out.print("Masukkan lebar balok : ");
                int lebar = input.nextInt();

                System.out.print("Masukkan tinggi balok : ");
                int tinggi = input.nextInt();

                Balok balok1 = new Balok(panjang, lebar, tinggi);
                balok1.menghitungLuas();
                balok1.menghitungVolume();
            break;

            case 3 :
                System.out.print("Masukkan jari-jari bola : ");
                int r = input.nextInt();

                Bola bola1 = new Bola(r);
                bola1.menghitungLuas();
                bola1.menghitungVolume();
            break;

            case 4 :
                System.out.print("Masukkan jari-jari tabung : ");
                int rt = input.nextInt();

                System.out.println("Masukkan tinggi tabung : ");
                int tt = input.nextInt();

                Tabung tabung1 = new Tabung (rt, tt);
                tabung1.menghitungLuas();
                tabung1.menghitungVolume();
            break;

            case 5 : 
                System.out.print("Masukkan sisi persegi : ");
                int s = input.nextInt();

                Persegi persegi1 = new Persegi (s);
                persegi1.menghitungLuas();
                persegi1.menghitungKeliling();
            break;

            case 6 :
                System.out.print("Masukkan panjang persegi panjang : ");
                int pp = input.nextInt();

                System.out.print("Masukkan lebar persegi panjang : ");
                int lp = input.nextInt();

                PersegiPanjang pj1 = new PersegiPanjang(pp, lp);
                pj1.menghitungLuas();
                pj1.menghitungKeliling();
            break;

            case 7 :
                System.out.print("Masukkan jari-jari lingkaran : ");
                int rl = input.nextInt();

                Lingkaran lingkaran1 = new Lingkaran (rl);
                lingkaran1.menghitungLuas();
                lingkaran1.menghitungKeliling();
            break;

            case 8 : 
                System.out.print("Masukkan sisi 1 trapesium : ");
                int s1 = input.nextInt();

                System.out.print("Masukkan sisi 2 trapesium : ");
                int s2 = input.nextInt();

                System.out.print("Masukkan sisi 3 trapesium : ");
                int s3 = input.nextInt();

                System.out.print("Masukkan sisi 4 trapesium : ");
                int s4 = input.nextInt();

                System.out.print("Masukkan tinggi trapesium : ");
                int t = input.nextInt();

                Trapesium tr = new Trapesium (s1, s2, s3, s4, t);
                tr.menghitungLuas();
                tr.menghitungKeliling();
            break;

            default :
                System.out.println("Pilihan tidak tersedia");

        }
        System.out.println("----------------------------------");
        input.close();
    }
}
