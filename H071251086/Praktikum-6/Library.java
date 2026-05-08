package tuprak6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Library {

    List<LibraryItem> items;
    List<Member> members;
    LibraryLogger logger;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    String addMember(Member member) {
        members.add(member);
        return "Anggota " + member.name + " berhasil ditambahkan";
    }

    LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemId == itemId)
                return item;
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.memberId == memberId)
                return member;
        }
        throw new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }

    String borrowItem(int memberId, int itemId, int days) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.borrow(item, days);
        logger.logBorrow(item.title, member.name);
        return result;
    }

    String returnItem(int memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.returnItem(item, daysLate);
        logger.logReturn(item.title, member.name);
        return result;
    }

    String getLibraryStatus() {
        if (items.isEmpty())
            return "Tidak ada item di perpustakaan.";

        int idWidth = 6;
        int judulWidth = 30;
        int statusWidth = 10;

        String border = "+" + "-".repeat(idWidth + 2)
                + "+" + "-".repeat(judulWidth + 2)
                + "+" + "-".repeat(statusWidth + 2) + "+";

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-" + idWidth + "s | %-" + judulWidth + "s | %-" + statusWidth + "s |%n",
                "ID", "Judul", "Status"));
        sb.append(border).append("\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-" + idWidth + "d | %-" + judulWidth + "s | %-" + statusWidth + "s |%n",
                    item.itemId, item.title, status));
        }
        sb.append(border);
        return sb.toString();
    }

    String getAllLogs() {
        return logger.getLogs();
    }
}
