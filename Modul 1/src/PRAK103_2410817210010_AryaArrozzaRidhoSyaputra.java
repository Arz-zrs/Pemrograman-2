import java.util.Scanner;

public class PRAK103_2410817210010_AryaArrozzaRidhoSyaputra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = sc.nextInt();
        do {
            if (num % 2 == 0) {
                num++;
            }
            if (N == 1) {
                System.out.print(num);
            }
            else {
                System.out.print(num + ", ");
                num += 2;
            }
            N--;
        }
        while (N > 0);
    }
}
