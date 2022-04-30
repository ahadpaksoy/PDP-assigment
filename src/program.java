/**
 *
 * @author Ahad Can PAKSOY ahad.paksoy@ogr.sakarya.edu.tr
 * @since 31.03.2022
 * <p>
 * main sınıfı
 * </p>
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class program {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        printer.PRINTER(args[0]);
        File fileName = new File("demo.txt"); // takes the path name
        String absolutePath = fileName.getAbsolutePath(); // returns the absolute path
        try
        {
            FileReader fr = new FileReader(absolutePath);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while((line=br.readLine()) != null)
            {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resources
            patterns.REGEX_PATTERNS(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(absolutePath);

        long estimatedTime = System.nanoTime() - startTime;

        System.out.println("estimatedTime: " + estimatedTime / 1_000_000_000.);
    }
}