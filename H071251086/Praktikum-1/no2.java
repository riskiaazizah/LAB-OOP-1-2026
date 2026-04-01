import java.util.Scanner;
public class no2 {
    
    public static void main(String[] args) {
        Scanner cihuy = new Scanner (System.in);
        

        System.out.print("Masukkan tanggal : ");
        String input = cihuy.nextLine();

        String hasil = konversiTanggal(input);
        System.out.println(hasil);

        cihuy.close();

}

    public static String konversiTanggal(String input) {
        String[] bagian = input.split("-");

        if (bagian.length != 3){
            return "Format salah! Harus dd-mm-yy. Contoh: 01-04-03";
        }

        String tanggal = bagian[0];
        String bulan = bagian [1];
        String tahun = bagian [2];

        if (tanggal.charAt(0) == '0') {
            tanggal= tanggal.substring(1);
        }

        String namaBulan = getNamaBulan(bulan);
        int tahunAngka = Integer.parseInt(tahun);
        String tahunPenuh = "";

        if (tahunAngka <= 30) {
            tahunPenuh = "20" + tahun;
        } else {
            tahunPenuh = "19" + tahun;
        }
        return tanggal + " " + namaBulan + " " + tahunPenuh;
    }

    public static String getNamaBulan(String bulan) {
        switch (bulan) {
            case "01"  : return "January";
            case "02" : return "February";
            case "03" : return "March";
            case "04" : return "April";
            case "05" : return "Mei";
            case "06" : return "June";
            case "07" : return "July";
            case "08" : return "August";
            case "09" : return "September";
            case "10" : return "OCtober";
            case "11" : return "November";
            case "12" : return "December";
            default : return "Bulan tidak valid!"; 

    
        } 
              
    }
    
}
