import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

public class NetStats {
	
	/**
	 * Randomly Chooses 
	 */
	NetStats(){
		
	}
	

	public String favoriteSites(int favoriteIndex){
		String[] sites = {"http://google.com", "http://facebook.com", "http://twitter.com", "http://instagr.am", "http://cnu.edu"};
		return sites[favoriteIndex];
	}
	/**
	 * Randomly returns a url from the favoriteSites array
	 */
	public String getSiteURL(){
		String site = "";
		Random random = new Random();
		int randomInt = random.nextInt(5);
		site = favoriteSites(randomInt);
		System.out.println(site);
		return site;
	}
	public Long[] siteStats(NetStats netStats, int numOfStats){
		Long[] stats;
		stats = new Long[numOfStats];
		long time1, pageLoadTime;
		for(int i = 0; i < numOfStats; i++){
			try {
			time1 = System.nanoTime();
			URL url = new URL(netStats.getSiteURL());
			URLConnection connection = url.openConnection();
			connection.getContent();
			pageLoadTime = System.nanoTime()-time1;
			stats[i] = pageLoadTime;
			
			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		
		
		return stats;
	}
	
	
	public static void main(String[] args){
		new NetStats();
	}
	
	

}

//	eventually setStats will provide the ability to change the favoriteSites list
//	public ArrayList setSites(){
//		return null;
//		
//	}