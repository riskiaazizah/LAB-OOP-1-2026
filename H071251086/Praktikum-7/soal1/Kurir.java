package soal1;
import java.util.Random;


class Kurir implements Runnable {
    Gudang gudang;
    Random random = new Random();

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int jumlah = random.nextInt(3) + 1; 
            gudang.ambilStok(jumlah);
            try {
                
                Thread.sleep(2000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

