package tuprak6;

public class Book extends LibraryItem {
        String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    String borrowItem(int days) {
        if (this.isBorrowed = true) {
            throw new IllegalArgumentException("Item " + title + " sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya dapat dipinjam maksimal 14 hari.");
        }
        this.isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

    void printBooks() {
        System.out.println(getDescription());
    }
 
}
