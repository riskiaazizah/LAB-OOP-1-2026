package soal1;

class Gudang {
    int stok;
    int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.stok = 0;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

   
    synchronized void tambahStok(int jumlah) {
        
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("[Pemasok] Gudang penuh! Menunggu... (Stok: " + stok + "/" + kapasitasMaksimal + ")");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        stok += jumlah;
        System.out.println("[Pemasok] Menambah " + jumlah + " barang | Stok: " + stok + "/" + kapasitasMaksimal);
        notifyAll();
    }

    synchronized void ambilStok(int jumlah) {
        while (stok < jumlah) {
            System.out.println("[Kurir] Stok tidak cukup! Menunggu... (Stok: " + stok + "/" + kapasitasMaksimal + ")");
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        stok -= jumlah;
        System.out.println("[Kurir] Mengambil " + jumlah + " barang | Stok: " + stok + "/" + kapasitasMaksimal);
        notifyAll(); 
    }

    public int getStok() { return stok; }
    public int getKapasitasMaksimal() { return kapasitasMaksimal; }
}