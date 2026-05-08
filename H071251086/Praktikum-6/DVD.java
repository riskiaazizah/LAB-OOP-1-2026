package tuprak6;

public class DVD extends LibraryItem {

    int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    @Override
    String borrowItem(int days) {
        if (this.isBorrowed) {
            throw new IllegalArgumentException("Item " + title + " sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 7) {
            throw new IllegalArgumentException("DVD hanya dapat dipinjam maksimal 7 hari.");
        }
        this.isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate * 25000;
    }

    int getDuration() { return duration; }
}
