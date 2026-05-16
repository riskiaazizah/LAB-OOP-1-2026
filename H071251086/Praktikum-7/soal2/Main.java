package soal2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

    
        List<String> documents = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            documents.add("Dokumen_" + i + ".txt");
        }

        ConcurrentHashMap<String, DocumentResult> results =
                new ConcurrentHashMap<>();

        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        CountDownLatch latch =
                new CountDownLatch(documents.size());

        for (String doc : documents) {

            executor.execute(() -> {

                long startTime =
                        System.currentTimeMillis();

                int wordCount =
                        DataProcessor.process(doc);

                long endTime =
                        System.currentTimeMillis();

                long duration =
                        endTime - startTime;

                String threadName =
                        Thread.currentThread().getName();

                DocumentResult result =
                        new DocumentResult(
                                doc,
                                threadName,
                                wordCount,
                                duration
                        );

                results.put(doc, result);

                System.out.println(
                        "[" + threadName.replace("pool-1-thread-", "Thread-") + "] "
                        + "Selesai memproses "
                        + doc
                        + " (" + wordCount + " kata)"
                        + " dalam "
                        + duration + " ms"
                );

                latch.countDown();
            });
        }

        latch.await();

        executor.shutdown();

                int  totalWords    = 0;
        long totalDuration = 0;
 
        for (String doc : documents) {
            totalWords    += results.get(doc).getWordCount();
            totalDuration += results.get(doc).getDuration();
        }
 
        double averageDuration =
                totalDuration / (double) documents.size();

        String line =
            "+------------------+-----------------+-------------+-------------+";
 
        System.out.println();
        System.out.println(line);
        System.out.printf(
            "| %-16s | %-15s | %11s | %11s |%n",
            "Nama Dokumen", "Thread", "Jumlah Kata", "Durasi (ms)"
        );
        System.out.println(line);
 
        for (String doc : documents) {
            DocumentResult r = results.get(doc);
            System.out.printf(
                "| %-16s | %-15s | %11d | %11d |%n",
                r.getDocumentName(),
                r.getThreadName(),
                r.getWordCount(),
                r.getDuration()
            );
        }
 
        System.out.println(line);
        System.out.printf(
            "| %-16s | %-15s | %11d | %11s |%n",
            "TOTAL", "-", totalWords, "-"
        );
        System.out.printf(
            "| %-16s | %-15s | %11s | %11.1f |%n",
            "RATA-RATA DURASI", "-", "-", averageDuration
        );
        System.out.println(line);
 
        System.out.printf(
            "%nTotal Kata Keseluruhan : %d kata%n", totalWords
        );
        System.out.printf(
            "Rata-rata Waktu Proses : %.1f ms%n", averageDuration
        );
    }
}
