package tuprak6;

import java.util.ArrayList;
import java.util.List;

class Member {

    String name;
    int memberId;
    List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException(
                    "Item " + item.title + " tidak tersedia, sudah dipinjam oleh anggota lain.");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    String returnItem(LibraryItem item, int daysLate) {
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        String fineFormatted = formatRupiah(fine);
        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + fineFormatted;
    }

    void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
        }

        int idWidth = 6;
        int judulWidth = 20;
        String border = "+" + "-".repeat(idWidth + 2) + "+" + "-".repeat(judulWidth + 2) + "+";

        System.out.println(border);
        System.out.printf("| %-" + idWidth + "s | %-" + judulWidth + "s |%n", "ID", "Judul");
        System.out.println(border);
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-" + idWidth + "d | %-" + judulWidth + "s |%n",
                    item.itemId, item.title);
        }
        System.out.println(border);
    }

    private String formatRupiah(double amount) {
        long val = (long) amount;
        String s = String.valueOf(val);
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0)
                result.insert(0, ".");
            result.insert(0, s.charAt(i));
            count++;
        }
        return result.toString();
    }

    String getName() {
        return name;
    }

    int getMemberId() {
        return memberId;
    }

    List<LibraryItem> getBorrowedItemsList() {
        return borrowedItems;
    }
}
