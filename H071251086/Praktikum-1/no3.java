import java.util.Scanner;
public class no3 {
    
    public static void main(String[] args) {
        Scanner cihuy = new Scanner(System.in);
        System.out.print("Masukkan password : ");

        String pw = cihuy.nextLine();
        
        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        cihuy.close();

        for (int i = 0; i < pw.length(); i++){
            char c = pw.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                adaHurufBesar = true;
            } else if (c >= 'a' && c<= 'z') {
                adaHurufKecil = true;
            }else if (c >= '0' && c <= '9') {
                adaAngka = true;
            }
        }


        if (pw.length() >= 8 && adaHurufBesar && adaHurufKecil && adaAngka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
    }

}
