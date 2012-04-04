import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile{
public void writeToFile(String filename, long time) {
        
        BufferedWriter bufferedWriter = null;
        String timerString = ""+ time +"";
        System.out.println(timerString);
        try {
            
            //Construct the BufferedWriter object
            bufferedWriter = new BufferedWriter(new FileWriter(filename));
            
            //Start writing to the output stream
            bufferedWriter.write(timerString);
//            bufferedWriter.write("Writing line one to file");
            bufferedWriter.newLine();
            bufferedWriter.write("Writing line two to file");
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Close the BufferedWriter
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
}