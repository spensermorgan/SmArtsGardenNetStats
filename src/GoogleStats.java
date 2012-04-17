//import java.io.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//public class GoogleStats {
//	private long time;
//	private long time1;
//	private long time2;
//	public static void main(String[]args){
//		
//	}
//	public long getGoogleStat(){
//		URL url;
//		try {
//			url = new URL("http://google.com");
//			time1 = System.nanoTime();
//			URLConnection connection;
//			connection = url.openConnection();
//			connection.getContent();
//			time2 = System.nanoTime();
//			time = time2-time1;
////			new WriteToFile().writeToFile("myFile.txt", time);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
////		System.out.println("Time to load Google = " + time + " nanoseconds.");
//		return time;
//	}
//
//}
