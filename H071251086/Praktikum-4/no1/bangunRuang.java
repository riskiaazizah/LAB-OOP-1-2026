package tuprak4.no1;

class bangunRuang {
  int sisi;

  public bangunRuang(int sisi) {
    this.sisi = sisi;
  }
  
  void menghitungLuas(){
    System.out.println("Luas bangun ruang");
  }

  void menghitungVolume(){
    System.out.println("Volume bangun ruang");
  }

}

class Kubus extends bangunRuang{
  Kubus(int sisi){
    super(sisi);
  }

  @Override
  void menghitungLuas(){
    int luas = 6 * sisi * sisi;
    System.out.println("Luas Kubus = " + luas);
  }

  @Override
  void menghitungVolume(){
    int volume = sisi * sisi * sisi;
    System.out.println("Volume Kubus = " + volume);
  }


}

class Balok extends bangunRuang{
  int panjang, lebar, tinggi;

  Balok(int panjang, int lebar, int tinggi){
    super(0);
    this.panjang = panjang;
    this.lebar = lebar;
    this.tinggi = tinggi;
  }

  @Override
  void menghitungLuas(){
    int luas = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    System.out.println("Luas Balok = " + luas);
  }

  @Override
  void menghitungVolume(){
    int volume = panjang * lebar * tinggi;
    System.out.println("Volume Balok = " + volume);
  }
}

class Bola extends bangunRuang{
  int jariJari;

  Bola(int jariJari){
    super(0);
    this.jariJari = jariJari;
  }
  @Override
  void menghitungLuas(){
    double luas = 4 * Math.PI * jariJari * jariJari* jariJari;
    System.out.printf("Luas Bola = %.2f\n", luas);
  }

  @Override
  void menghitungVolume(){
    double volume = (4.0/3.0) * Math.PI * jariJari * jariJari;
    System.out.printf("Volume Bola = %.2f",  volume);
  }
}

class Tabung extends bangunRuang{
  int jariJari, tinggi;

  Tabung(int jariJari, int tinggi){
    super(0);
    this.jariJari = jariJari;
    this.tinggi = tinggi;
  }

  @Override
  void menghitungLuas(){
    double luas = 2 * Math.PI * jariJari * (jariJari + tinggi);
    System.out.printf("Luas Tabung = %.2f\n", luas);
  }

  @Override
  void menghitungVolume(){
    double volume = Math.PI * jariJari * jariJari * tinggi;
    System.out.printf("Volume Tabung = %.2f\n", volume);
  }
}
  
