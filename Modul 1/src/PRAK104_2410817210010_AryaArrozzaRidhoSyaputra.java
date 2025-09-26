import java.util.Scanner;

public class PRAK104_2410817210010_AryaArrozzaRidhoSyaputra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tangan Abu: ");
        String abu = sc.nextLine().replaceAll(" ", "").toUpperCase();

        System.out.print("Tangan Bagas: ");
        String bagas = sc.nextLine().replaceAll(" ", "").toUpperCase();

        int abuScore = 0;
        int bagasScore = 0;
        for (int i = 0; i < 3; i++) {
            char a = abu.charAt(i);
            char b = bagas.charAt(i);

            if (a != b) {
                if ((a == 'B' && b == 'G') || (a == 'G' && b == 'K') || (a == 'K' && b == 'B')) {
                    abuScore++;
                }
                else {
                    bagasScore++;
                }
            }
        }

        if (abuScore > bagasScore) {
            System.out.print("Abu");
        }
        else if (bagasScore > abuScore) {
            System.out.print("Bagas");
        }
        else {
            System.out.print("Seri");
        }
    }
}
