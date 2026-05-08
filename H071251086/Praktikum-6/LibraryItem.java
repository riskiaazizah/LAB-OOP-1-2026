package tuprak6;

abstract class LibraryItem {

    String title;
    int itemId;
    boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    abstract String getDescription();

    abstract String borrowItem(int days);

    abstract double calculateFine(int daysLate);

    public String returnItem() {
        this.isBorrowed = false;
        return title + " dikembalikan";
    }
}
