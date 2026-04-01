import java.util.Scanner;
public class no5 {
    
    public static void main(String[] args) {
        Scanner cihuy = new Scanner(System.in);
        

        try {
            System.out.print("Input angka : ");
            int cari = cihuy.nextInt();

            int[][] nums = {{2,2,2}, {4,5,6}, {7,8,9}};

            for (int baris = 0; baris< nums.length; baris++){
                for (int kolom = 0; kolom<nums[baris].length; kolom++){
                    if (nums[baris][kolom] == cari) {
                        System.out.println("Found " + cari + " at : [" + baris + "][" + kolom + "]" );

                    
                    }
                }
            }

            cihuy.close();
            // System.out.println("Angka tidak ditemukan!");

        } catch (Exception e) {
            System.out.println("Input harus berupa angka bulat!");
        }
    }
}
