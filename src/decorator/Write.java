package decorator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @author Jerry Salonen
 */
public class Write implements ReadWriteState {

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
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            System.out.println("Write your content here:");
            String contents = sc.nextLine();

            bw.write(contents);

            bw.close();

            return "Wrote: " + contents + " - to file.";
        } catch (Exception e) {
            return "File could not be created.";
        }

    }
}
