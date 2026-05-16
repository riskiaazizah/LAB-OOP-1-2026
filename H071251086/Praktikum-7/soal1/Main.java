package soal1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        
        Gudang gudang = new Gudang(17);

        
        ExecutorService pemasokPool = Executors.newFixedThreadPool(2);
        ExecutorService kurirPool = Executors.newFixedThreadPool(3);

        Thread monitorThread = new Thread(new Monitoring(gudang));
        monitorThread.start();

        pemasokPool.execute(new Pemasok(gudang));
        pemasokPool.execute(new Pemasok(gudang));

        kurirPool.execute(new Kurir(gudang));
        kurirPool.execute(new Kurir(gudang));
        kurirPool.execute(new Kurir(gudang));

        System.out.println("=== Sistem berjalan selama 15 detik ===\n");

        Thread.sleep(15000);

        System.out.println("\n=== Menghentikan semua thread... ===");

        pemasokPool.shutdownNow();
        kurirPool.shutdownNow();
        monitorThread.interrupt();

        System.out.println("=== Sistem selesai. Stok akhir: " + gudang.getStok() + " ===");
        
        // pemasokPool.awaitTermination(5, TimeUnit.SECONDS);
        // kurirPool.awaitTermination(5, TimeUnit.SECONDS)
    }
}
