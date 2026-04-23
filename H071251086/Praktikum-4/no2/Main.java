package tuprak4.no2;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        ArrayList<Product> daftarProduk = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("==========TOKONYA ANDI===========");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih Menu: ");
            int pilihan = input.nextInt();
            input.nextLine();


            if (pilihan == 1) {

                System.out.println("\n=== Tambah Produk ===");
                System.out.print("Brand           : ");
                String brand = input.nextLine();

                System.out.print("Serial Number      : ");
                int seriesNumber = input.nextInt();

                System.out.print("Price           : ");
                double price = input.nextDouble();

                System.out.println("\nPilih Tipe Produk");
                System.out.println("1. Smartphone");
                System.out.println("2. Laptop");
                System.out.println("3. Camera");
                System.out.print("Pilihan: ");
                int tipe = input.nextInt();
                // input.nextLine();

                Product product;

                if (tipe == 1) {
                    System.out.print("Screen Size    : ");
                    double screenSize = input.nextDouble();

                    System.out.print("Storage Capacity    : ");
                    int storage = input.nextInt();

                    product = new Smartphone(brand, seriesNumber, price, screenSize, storage);
                    daftarProduk.add(product);
                }

                else if (tipe == 2) {
                    System.out.print("Processor Type  : ");
                    String processor = input.nextLine();
                    input.nextLine();
                    System.out.print("RAM Size       : ");
                    int ram = input.nextInt();

                    product = new Laptop(brand, seriesNumber, price, ram, processor);
                    daftarProduk.add(product);
                }

                else if (tipe == 3) {
                    System.out.print("Resolution (MP) : ");
                    int resolution = input.nextInt();
                    input.nextLine();

                    System.out.print("Lens Type       : ");
                    String lens = input.nextLine();

                    product = new Camera(brand, seriesNumber, price, resolution, lens);
                    daftarProduk.add(product);
                }

                System.out.println("\nProduk berhasil ditambahkan!");
            }

            else if (pilihan == 2) {

                System.out.println("\n===== DAFTAR PRODUK =====");

                if (daftarProduk.isEmpty()) {
                    System.out.println("Belum ada produk.");
                } else {
                    for (Product p : daftarProduk) {
                        System.out.println("------------------------------");
                        p.displayInfo();
                    }
                }
            }


            else if (pilihan == 3) {

                System.out.print("\nMasukkan nomor seri produk: ");
                int cari = input.nextInt();

                boolean ditemukan = false;

                for (Product p : daftarProduk) {
                    if (p.seriesNumber == cari) {
                        System.out.println("\nProduk ditemukan:");
                        System.out.println("------------------------------");
                        p.displayInfo();
                        System.out.println("\nPembelian berhasil!");
                        daftarProduk.remove(p);
                        ditemukan = true;
                        break;
                    }
                }

                if (!ditemukan) {
                    System.out.println("Produk tidak ditemukan.");
                }
            }

            else if (pilihan == 4) {
                System.out.println("\nTerima kasih telah menggunakan sistem.");
                break;
            }

            else {
                System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }
}
