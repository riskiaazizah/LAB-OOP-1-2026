package soal1;


class Monitoring implements Runnable {
    Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            tampilkanStatus();
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }


    void tampilkanStatus() {
        int stok = gudang.getStok();
        int max = gudang.getKapasitasMaksimal();
        double persentase =  ((double) stok / max * 100);
        int panjangBar = 20;
        int isi = (int) ((double) stok / max * panjangBar);

        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < panjangBar; i++) {
            bar.append(i < isi ? "#" : "-");
        }
        bar.append("]");

        System.out.print("Status Gudang: " + bar + " ");
        System.out.printf("%.2f", persentase);
        System.out.println("%");
    }
}