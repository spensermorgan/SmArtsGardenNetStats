import java.io.*;

import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import junit.framework.Test;
import jm.gui.*;

public class SmArtsGardenNetStats implements JMC {
	static long time1;
	static long time;
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
		
		
	}
}
