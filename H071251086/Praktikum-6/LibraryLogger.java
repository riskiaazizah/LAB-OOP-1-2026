package tuprak6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class LibraryLogger {

    static class LogEntry {
        String timestamp;
        String title;
        String memberName;
        String returnedAt;

    LogEntry(String timestamp, String title, String memberName) {
        this.timestamp = timestamp;
        this.title = title;
        this.memberName = memberName;
        this.returnedAt = null;
        }
    }

    List<LogEntry> logs;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(formatter);
        return timestamp + " " + activity;
    }

    void logBorrow(String title, String memberName) {
        String timestamp = LocalDateTime.now().format(formatter);
        logs.add(new LogEntry(timestamp, title, memberName));
    }

    void logReturn(String title, String memberName) {
        String timestamp = LocalDateTime.now().format(formatter);
        for (int i = logs.size() - 1; i >= 0; i--) {
            LogEntry entry = logs.get(i);
            if (entry.title.equals(title) && entry.memberName.equals(memberName) && entry.returnedAt == null) {
                entry.returnedAt = timestamp;
                return;
            }
        }
        LogEntry entry = new LogEntry(timestamp, title, memberName);
        entry.returnedAt = timestamp;
        logs.add(entry);
    }

    String getLogs() {
        if (logs.isEmpty()) return "Tidak ada log aktivitas.";

        int dipinjamWidth = 20;
        int judulWidth = 30;
        int memberWidth = 15;
        int dikembalikanWidth = 20;

        String border = "+" + "-".repeat(dipinjamWidth + 2)
                      + "+" + "-".repeat(judulWidth + 2)
                      + "+" + "-".repeat(memberWidth + 2)
                      + "+" + "-".repeat(dikembalikanWidth + 2) + "+";

        StringBuilder sb = new StringBuilder();
        sb.append(border).append("\n");
        sb.append(String.format("| %-" + dipinjamWidth + "s | %-" + judulWidth + "s | %-"
                + memberWidth + "s | %-" + dikembalikanWidth + "s |%n",
                "Dipinjam pada", "Judul", "Member", "Dikembalikan pada"));
        sb.append(border).append("\n");
        for (LogEntry entry : logs) {
            String returnedAt = entry.returnedAt != null ? entry.returnedAt : "-";
            sb.append(String.format("| %-" + dipinjamWidth + "s | %-" + judulWidth + "s | %-"
                    + memberWidth + "s | %-" + dikembalikanWidth + "s |%n",
                    entry.timestamp, entry.title, entry.memberName, returnedAt));
        }
        sb.append(border);
        return sb.toString();
    }

    void clearLogs() {
        logs.clear();
    }
}
