import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import junit.framework.Test;
import jm.gui.*;

public class SmArtsGardenNetStats implements JMC {
	static long time1;
	static long time;
	static long time2;
	private static Note n, o ,t, e;
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("myFile.txt");
		BufferedReader br = new BufferedReader(fr);
		Phrase phr = new Phrase();
		Part part = new Part();
		Score score = new Score();
		
		n = new Note(C4, QUARTER_NOTE);
		
		phr.addNote(n);
		part.add(phr);
		score.add(part);
		//test
		
		faceBookStat();
		String s;
		while((s = br.readLine()) != null){
			System.out.println(s);
			t = new Note(F5,QUARTER_NOTE);
		}
		phr.add(t);
		View.notate(score);
	}
	
	public static void faceBookStat(){
		 try {
	        	
			 	time1 = System.nanoTime();
	            URL url = new URL("http://facebook.com");
//	            URLConnection connection = url.openConnection();
	            URLConnection connection = url.openConnection();
	            connection.getContent();
	            time2 = System.nanoTime();
//	            System.out.println(time2-time);
	            time = time2-time1;
//	            Map responseMap = connection.getHeaderFields();
//	            for (Iterator iterator = responseMap.keySet().iterator(); iterator.hasNext();) {
//	                String key = (String) iterator.next();
//	                System.out.print(key + " = ");
	//
//	                List values = (List) responseMap.get(key);
//	                for (int i = 0; i < values.size(); i++) {
//	                    Object o = values.get(i);
//	                    System.out.print(o + ", ");
//	                }
//	                System.out.println("");
//	            }
	            new WriteToFile().writeToFile("myFile.txt", time);
	            
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
}
