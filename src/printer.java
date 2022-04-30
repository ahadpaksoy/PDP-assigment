/**
 *
 * @author Ahad Can PAKSOY ahad.paksoy@ogr.sakarya.edu.tr
 * @since 31.03.2022
 * <p>
 * Girdi dosyasının okunup yorum satırlarından arındırıldıktan sonra demo.txt dosyasına yazdırma işleminin yapıldığı sınıf
 * </p>
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class printer {
    public static void PRINTER(String data) {

        /*
         *       I introduced a variable wether currently there is an comment.
         *       You have to set the boolean to false after working with the current line, because this line has to be ignored too.
         *       Basically the program recognizes comments by "/" and then the end of a comment by "/" and simple single line comments by "//".
         *       Every other line will be proceeded.
         *  */
        System.out.println("e.g Deneme.java");
        File demo = new File("demo.txt"); // takes the path name
        String absolutePath = demo.getAbsolutePath();   // creates absolute path
        try {
            BufferedReader reader = new BufferedReader(new FileReader(data)); // reads line by line users input file
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(absolutePath)); // writes line by line to demo.txt

            boolean currentlyInComment = false;

            String line = reader.readLine();

            while (line != null) {

                if (line.trim().startsWith("/*")) {
                    currentlyInComment = true; // when reader sees comment line starter, changes variable to true
                }

                if (!currentlyInComment && !line.trim().startsWith("//")) {
                    writer.write(line); // writes current line
                    writer.newLine(); //  and goes to next line
                }

                if (line.trim().startsWith("*/") && currentlyInComment) {
                    currentlyInComment = false;
                }

                line = reader.readLine();

            }
            // this loop starts trim when sees comment opening parameter  and ends when sees comment closing parameter
            writer.close();
            reader.close();
            // closes buffered writer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}