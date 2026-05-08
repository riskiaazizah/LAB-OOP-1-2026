package tuprak6;

import java.util.Scanner;
import java.util.NoSuchElementException;

class Main {

    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");

        while (true) {
            printMenu();
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1": tambahItem(); break;
                case "2": tambahAnggota(); break;
                case "3": pinjamItem(); break;
                case "4": kembalikanItem(); break;
                case "5": lihatStatus(); break;
                case "6": lihatLog(); break;
                case "7": lihatItemDipinjamAnggota(); break;
                case "8":
                    System.out.println("Terima kasih. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
            System.out.println();
        }
    }

    static void printMenu() {
        System.out.println("-------------------------------------");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
        System.out.println("-------------------------------------");
    }

    static void tambahItem() {
        System.out.println("\n-- Tambah Item --");
        System.out.println("Jenis item:");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        System.out.print("Pilih jenis: ");
        String jenis = scanner.nextLine().trim();

        System.out.print("Judul: ");
        String judul = scanner.nextLine().trim();
        System.out.print("ID Item: ");
        int id = readInt();

        if (jenis.equals("1")) {
            System.out.print("Penulis: ");
            String author = scanner.nextLine().trim();
            Book book = new Book(judul, id, author);
            System.out.println(library.addItem(book));
        } else if (jenis.equals("2")) {
            System.out.print("Durasi (menit): ");
            int durasi = readInt();
            DVD dvd = new DVD(judul, id, durasi);
            System.out.println(library.addItem(dvd));
        } else {
            System.out.println("Jenis tidak valid.");
        }
    }

    static void tambahAnggota() {
        System.out.println("\n-- Tambah Anggota --");
        System.out.print("Nama: ");
        String nama = scanner.nextLine().trim();
        System.out.print("ID Anggota: ");
        int id = readInt();

        Member member = new Member(nama, id);
        System.out.println(library.addMember(member));
    }

    static void pinjamItem() {
        System.out.println("\n-- Pinjam Item --");
        System.out.print("ID Anggota: ");
        int memberId = readInt();
        System.out.print("ID Item: ");
        int itemId = readInt();
        System.out.print("Jumlah hari pinjam: ");
        int days = readInt();

        try {
            String result = library.borrowItem(memberId, itemId, days);
            System.out.println(result);
        } catch (NoSuchElementException | IllegalArgumentException | IllegalStateException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    static void kembalikanItem() {
        System.out.println("\n-- Kembalikan Item --");
        System.out.print("ID Anggota: ");
        int memberId = readInt();
        System.out.print("ID Item: ");
        int itemId = readInt();
        System.out.print("Keterlambatan (hari, 0 jika tepat waktu): ");
        int daysLate = readInt();

        try {
            String result = library.returnItem(memberId, itemId, daysLate);
            System.out.println(result);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    static void lihatStatus() {
        System.out.println("\n-- Status Perpustakaan --");
        System.out.println(library.getLibraryStatus());
    }

    static void lihatLog() {
        System.out.println("\n-- Log Aktivitas --");
        System.out.println(library.getAllLogs());
    }

    static void lihatItemDipinjamAnggota() {
        System.out.println("\n-- Item yang Dipinjam Anggota --");
        System.out.print("ID Anggota: ");
        int memberId = readInt();

        try {
            Member member = library.findMemberById(memberId);
            System.out.println("Anggota: " + member.getName());
            member.getBorrowedItems();
        } catch (NoSuchElementException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }

    static int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Input harus angka, coba lagi: ");
            }
        }
    }
}
