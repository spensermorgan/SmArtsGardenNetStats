//import java.io.*;
//import java.sql.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//import jm.music.data.*;
//import jm.JMC;
//import jm.util.*;
//import junit.framework.Test;
//import jm.gui.*;
//
//public class SmArtsGardenNetStats implements JMC {
//	static long time1;
//	static long time;
//	static long time2;
//	private static Note n, o ,t, e;
//	
//	
//	
////	public Connection getConnection() throws SQLException{
////		Connection conn = null;
////		return conn;
////		Properties connectionProps = new Properties();
////		
////	}
//	
//	File statsFile = new File("statsFile.txt");
//	
//	public static void main(String[] args) throws IOException{
//
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//				System.out.println("driver found!");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
////			try{
////				String data = "jdbc:mysql:MySQL:3306";
////				String user = "spenser";
////				String password = "password";
////				Connection dbConnection = DriverManager.getConnection(data, user, password);
////			}
////			catch(SQLException e){
////				System.out.println("couldn't connect to sql");
////			}
//			
////		FileWriter writer = new FileWriter(statsFile,true);
//			SmArtsGardenNetStats stats = new SmArtsGardenNetStats();
//			stats.getStats();
//			FileReader fr = new FileReader("statsFile.txt");
//		BufferedReader br = new BufferedReader(fr);
//		Phrase phr = new Phrase();
//		Part part = new Part();
//		Score score = new Score();
//		
//		n = new Note(C4, QUARTER_NOTE);
//		
//		phr.addNote(n);
//		part.add(phr);
//		score.add(part);
//		//test
//		
//		String s;
//		char[] chars;
//		while((s = br.readLine()) != null){
//			chars = s.toCharArray();
//			System.out.println(s);
////			System.out.println(chars);
////			System.out.println(chars.length);
////			t = new Note(F5,QUARTER_NOTE);
//		}
////		phr.add(t);
////		View.notate(score);
//	}
//	
//	
//	public long faceBookStat(){
//		 try {
//	        	
//			 	time1 = System.nanoTime();
//	            URL url = new URL("http://facebook.com");
////	            URLConnection connection = url.openConnection();
//	            URLConnection connection = url.openConnection();
//	            connection.getContent();
//	            time2 = System.nanoTime();
////	            System.out.println(time2-time);
//	            time = time2-time1;
//	            
////	            Map responseMap = connection.getHeaderFields();
////	            for (Iterator iterator = responseMap.keySet().iterator(); iterator.hasNext();) {
////	                String key = (String) iterator.next();
////	                System.out.print(key + " = ");
//	//
////	                List values = (List) responseMap.get(key);
////	                for (int i = 0; i < values.size(); i++) {
////	                    Object o = values.get(i);
////	                    System.out.print(o + ", ");
////	                }
////	                System.out.println("");
////	            }
////	            new WriteToFile().writeToFile("myFile.txt", time);
////	            FileWrite(time,true);
//	            
//	        } catch (MalformedURLException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//		return time;
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
////			FileWrite(time,true);
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
//	public void getStats(){
//		FileWrite(faceBookStat(), false);
//		FileWrite(getGoogleStat(), true);
//		FileWrite(faceBookStat(), true);
//		FileWrite(getGoogleStat(), true);
//		FileWrite(faceBookStat(), true);
//		FileWrite(getGoogleStat(), true);
//		FileWrite(faceBookStat(), true);
//		FileWrite(getGoogleStat(), true);
//		FileWrite(faceBookStat(), true);
//		FileWrite(getGoogleStat(), true);
//		FileWrite(faceBookStat(), true);
//		
//	}
//	
//	public  void FileWrite(long time, Boolean fresh){
//			
//			try{
//				
//				FileWriter fstream = new FileWriter(statsFile);
//				BufferedWriter out = new BufferedWriter(fstream);
//				if(fresh){
//					out.append(""+ time+ "");
//					out.newLine();
//					out.close();
//				}
//				else{
//				// Create file 
////					statsFile = new File("statsFile.txt");
////					fstream = new FileWriter(statsFile);
//				out.write(""+time+"");
//				out.newLine();
////		  out.write("Hello Java");
//				//Close the output stream
//				out.close();
//				}
//				out.close();
//				
//			}catch (Exception e){//Catch exception if any
//				System.err.println("Error: " + e.getMessage());
//			}
//			}
//		
//	
//}
