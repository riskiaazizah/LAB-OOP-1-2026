package soal2;

public class DocumentResult {

    String documentName;
    String threadName;
    int wordCount;
    long duration;

    public DocumentResult(String documentName,
                          String threadName,
                          int wordCount,
                          long duration) {

        this.documentName = documentName;
        this.threadName = threadName;
        this.wordCount = wordCount;
        this.duration = duration;
    }

    public String getDocumentName() {
        return documentName;
    }

    public String getThreadName() {
        return threadName;
    }

    public int getWordCount() {
        return wordCount;
    }

    public long getDuration() {
        return duration;
    }
}
