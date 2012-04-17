import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteToFile{
	public static void main(String[] args){
		
	}
//	public void writeToFile(String filename, long time){
//		try {
//			FileOutputStream filestream = new FileOutputStream(filename);
//			ObjectOutputStream os = new ObjectOutputStream(filestream);
//			String thistime = "" + time + "";
//			os.writeObject(thistime);
//			os.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//public void writeToFile(String filename, long time) {
//        
//        BufferedWriter bufferedWriter = null;
//        String timerString = ""+ time +"";
//        System.out.println(timerString);
//        try {
//        	FileWriter writer = new FileWriter(filename);
//            writer.append(timerString);
//            //Construct the BufferedWriter object
////            bufferedWriter = new BufferedWriter(new FileWriter(filename));
////            
////            //Start writing to the output stream
////            bufferedWriter.append(timerString);
////            bufferedWriter.newLine();
////            bufferedWriter.write("Writing line one to file");
////            bufferedWriter.write("Writing line two to file");
//            
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            //Close the BufferedWrite
//            try {
//                if (bufferedWriter != null) {
//                    bufferedWriter.flush();
//                    bufferedWriter.close();
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//	}
	public static void fileWrite(long time){
		try{
		  // Create file 
		  FileWriter fstream = new FileWriter("out.txt",true);
		  BufferedWriter out = new BufferedWriter(fstream);
		  out.append(""+time+"");
		  out.newLine();
//		  out.write("Hello Java");
		  //Close the output stream
		  out.close();
		  }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
	}
	public void closeFile(WriteToFile file){
		
	}
}