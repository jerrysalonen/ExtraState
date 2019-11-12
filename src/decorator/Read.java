package decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Jerry Salonen
 */
public class Read implements ReadWriteState {

    @Override
    public String processFile() {
        System.out.println("Directory (e.g. C:\\Users\\myuser). Leave blank to use your user directory.");
        Scanner sc = new Scanner(System.in);
        String directory = sc.nextLine();

        if (directory.length() < 1) {
            directory = System.getProperty("user.home");
        }

        System.out.println("Input file name.");
        String fileName = sc.nextLine();

        String path = directory + "\\" + fileName;


        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String contents = "";
            String st = "";

            while ((st = br.readLine()) != null) {
                contents += st;
            }

            br.close();

            return contents;
        } catch (Exception e) {
            return "File not found";
        }

    }
}
