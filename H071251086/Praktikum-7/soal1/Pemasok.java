package soal1;

import java.util.Random;

class Pemasok implements Runnable {
    Gudang gudang;
    Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int jumlah = random.nextInt(5) + 1; 
            gudang.tambahStok(jumlah);
            try {
                
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}