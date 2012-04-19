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
	NetStats() {

	}

	public String favoriteSites(int favoriteIndex) {
		String[] sites = { "http://google.com", "http://facebook.com",
				"http://twitter.com", "http://instagr.am", "http://cnu.edu",
				"http://joomla.org" };
		return sites[favoriteIndex];
	}

	/**
	 * Randomly returns a URL from the favoriteSites array
	 */
	public String getSiteURL() {
		String site = "";
		Random random = new Random();
		int randomInt = random.nextInt(6);
		site = favoriteSites(randomInt);
		System.out.println(site);
		return site;
	}
	/**
	 * Gets the statistics of web sites randomly chosen from the list in favoriteSites.
	 * 
	 * @param netStats - allows multiple stats to be obtained at once (for two different instruments possibly).
	 * @param numOfStats - specify the number of stats you want to obtain. Also determines the number of connections to random sites.
	 * @return - an Array of site stats of length numOfStats.
	 */
	public Long[] siteStats(NetStats netStats, int numOfStats) {
		Long[] stats;
		stats = new Long[numOfStats];
		long time1, pageLoadTime;
		for (int i = 0; i < numOfStats; i++) {
			try {
				time1 = System.nanoTime();
				URL url = new URL(netStats.getSiteURL());
				URLConnection connection = url.openConnection();
				connection.getContent();
				pageLoadTime = System.nanoTime() - time1;
				stats[i] = pageLoadTime;

			} catch (MalformedURLException e) {
				System.out.println("URL not found or incorrect");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Unable to load site content");
				e.printStackTrace();
			}
		}

		return stats;
	}

	public static void main(String[] args) {
		new NetStats();
	}

}

// eventually setStats will provide the ability to change the favoriteSites list
// public ArrayList setSites(){
// return null;
//
// }