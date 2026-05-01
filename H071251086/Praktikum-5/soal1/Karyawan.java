package tuprak5.soal1;

abstract class Karyawan{
    private String nama, idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan){
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    void absen(){
        jumlahKehadiran++;
    }

    String getNama(){
        return nama;
    }

    String getIdKaryawan(){
        return idKaryawan;
    }

    int getJumlahKehadiran(){
        return jumlahKehadiran;
    }

    abstract double hitungGaji();
    
}

class KaryawanTetap extends Karyawan{
    double gajiPokok;
    double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan){
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji(){
        double totalGaji =  gajiPokok + (tunjanganMakan * getJumlahKehadiran());
        return totalGaji;
    }

    public double hitungGaji(double bonusKinerja){
        double totalGaji =  hitungGaji() + bonusKinerja;
        return totalGaji;
    }
}

class KaryawanKontrak extends Karyawan{
    double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari){
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji(){
        double gajiAwal = upahPerHari * getJumlahKehadiran();
        double totalGaji = getJumlahKehadiran() > 20? gajiAwal += 500000 : gajiAwal;
            return totalGaji;
    
        }

    }

    //compile = javac tuprak5/soal1/Karyawan.java
    //compile 2 = java tuprak5.soal1.Main

class Main {

    public static void main(String[] args) {
        

        KaryawanTetap kt = new KaryawanTetap("Aqil", "A-008", 7000000, 50000);

        for (int i = 0; i<22; i++) kt.absen();

        double bonusKinerja = 1500000;

        System.out.println("===Karyawan Tetap===");
        System.out.println("Nama : " + kt.getNama());
        System.out.println("ID Karyawan : " + kt.getIdKaryawan());
        System.out.println("Jumlah Hadir : " + kt.getJumlahKehadiran());
        System.out.println("Gaji sementara : Rp" + kt.hitungGaji());
        System.out.println("Gaji akhir (+bonus) : Rp" + kt.hitungGaji(bonusKinerja));

        System.out.println();


        KaryawanKontrak kk = new KaryawanKontrak("Fauzi","F-009", 300000);

        for (int i = 0; i<25; i++) kk.absen();
        System.out.println("===Karyawan Kontrak");
        System.out.println("Nama : " + kk.getNama());
        System.out.println("ID Karyawan : " + kk.getIdKaryawan());
        System.out.println("Total Gaji : Rp" + kk.hitungGaji());
    }
}