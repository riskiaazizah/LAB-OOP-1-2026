package tuprak4.no1;

class bangunDatar {
    int sisi;

    public bangunDatar(int sisi) {
        this.sisi = sisi;
    }

    void menghitungLuas(){
        System.out.println("Luas bangun datar");
    }

    void menghitungKeliling(){
        System.out.println("Keliling bangun datar");
    }
}

class Persegi extends bangunDatar{

    Persegi(int sisi){
        super(sisi);
    }

    @Override
    void menghitungLuas(){
        int luas = sisi * sisi;
        System.out.println("Luas Persegi = " + luas);
    }

    @Override
    void menghitungKeliling(){
        int Keliling = 4 * sisi;
        System.out.println("Keliling Persegi = " + Keliling);
    }

}

class PersegiPanjang extends bangunDatar{

    int panjang, lebar;

    PersegiPanjang(int panjang, int lebar){
        super(0);
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    void menghitungLuas(){
        int luas = panjang * lebar;
        System.out.println("Luas Persegi Panjang = " + luas);
    }

    @Override
    void menghitungKeliling(){
        int keliling = 2 * (panjang + lebar);
        System.out.println("Keliling Persegi Panjang = " + keliling);
    }
}

class Lingkaran extends bangunDatar{
    int jariJari;

    Lingkaran(int jariJari){
        super(0);
        this.jariJari = jariJari;
    }

    @Override
    void menghitungLuas(){
        double luas = Math.PI * jariJari *jariJari;
        System.out.printf("Luas Lingkaran = %.2f\n", luas);
    }

    @Override
    void menghitungKeliling(){
        double keliling = 2 * Math.PI *jariJari;
        System.out.printf("Keliling Lingkaran = %.2f\n",  keliling);
    }
}

class Trapesium extends bangunDatar{
    int sisi1, sisi2, sisi3, sisi4, tinggi;

    Trapesium(int sisi1, int sisi2, int sisi3, int sisi4, int tinggi){
        super(0);
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
        this.tinggi = tinggi;
    }

    @Override
    void menghitungLuas(){
        double luas = (1.0/2.0) * (sisi1 + sisi2) * tinggi;
        System.out.printf("Luas Trapesium = %.2f\n", luas);
    }

    @Override 
    void menghitungKeliling(){
        int keliling = sisi1 + sisi2 + sisi3 + sisi4;
        System.out.printf("Keliling Trapesium = %.2f\n", keliling);
    }
    
}