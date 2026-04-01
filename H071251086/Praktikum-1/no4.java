import java.util.Scanner;
public class no4 {
    
    public static void main(String[] args) {
        Scanner cihuy = new Scanner(System.in);
        System.out.print("Masukkan angka : ");

        if (!cihuy.hasNextInt()) {
            System.out.println("Input harus berupa angka!");
            cihuy.close();
            return;
        }
        
        int angka = cihuy.nextInt(); 
        cihuy.close();

        if (angka <0) {
            System.out.println("Error : Angka negatif tidak punya faktorial!");
            return;
        }

        int hasil = faktorial(angka);
        System.out.println("Hasil faktorial : " + hasil);
    }

    public static int faktorial(int n) {
        if (n == 0 || n ==1) {
            return 1;
        }else {
            return n * faktorial(n-1);
        }

    }
}
