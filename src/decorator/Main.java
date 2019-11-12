package decorator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select = -1;
        ReadWriteContext rwc = new ReadWriteContext();

        do {
            System.out.println("1: Read\n2: Write\n0: Close");

            try {
                select = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }

            switch(select) {
                case 1:
                    rwc.setState(new Read());
                    break;
                case 2:
                    rwc.setState(new Write());
                    break;
            }

            if (select < 3) {
                System.out.println(rwc.processFile());
            }

        } while (select != 0);


    }
}
