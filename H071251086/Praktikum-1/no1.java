import java.util.Scanner;
public class no1{
    
    public static void main(String[] args) {
        Scanner cihuy = new Scanner(System.in);
        cihuy.close();

        System.out.print("Masukkan judul film : ");
        String judul = cihuy.nextLine();
        // System.out.println(judul.toLowerCase());

        String hasilTampilan = formatKapital(judul);
        System.out.println(hasilTampilan);
    
    }

    public static String formatKapital(String input) {
        String[] bagidua = input.split(" ");
        String hasil = "";

        for (String kata : bagidua ) {
            if (kata.length() > 0) {
                String awal = kata.substring(0,1).toUpperCase();
                String sisa = kata.substring(1).toLowerCase();

                hasil += awal + sisa + " ";
            }
        }
        return hasil.trim();
    }

    }

