import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an amount of page frames (1-6 inclusive): ");
        String userIn = in.nextLine();
        while (!(userIn.equals("1") || userIn.equals("2") || userIn.equals("3") || userIn.equals("4") || userIn.equals("5") || userIn.equals("6"))) {
            System.out.println("Invalid input");
            System.out.println("Please enter an amount of page frames (1-6 inclusive): ");
            userIn = in.nextLine();
        }

        int frames = Integer.parseInt(userIn);
        int len = 20;
        int[] refString = new int[20];
        Die d = new Die(10);
        for (int i = 0; i < len; i++) {
            d.roll();
            refString[i] = d.getCurrentValue() - 1;
        }

        int i = 0;
        boolean fin = false;

        System.out.print("\nFor reference string {");
        for (i = 0; i < len-1; i++)
        {
            System.out.print(refString[i] + ", ");
        }
        System.out.print(refString[i] + "}:\n");

        for(int j = 1; j <= frames; j++)
        {
            if (j  == frames) {
                fin = true;
            }

            Fifo f = new Fifo();
            f.fifo(j , len, refString, fin);

            Lru l = new Lru();
            l.lru(j , len, refString, fin);

            Opt o = new Opt();
            o.optimal(j , len, refString, fin);

        }

    }
}
