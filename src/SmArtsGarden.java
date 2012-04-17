import java.applet.Applet;

import java.awt.Frame;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFrame;

import jm.JMC;
import jm.gui.cpn.GrandStave;
import jm.gui.show.ShowScore;
//import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;
import jm.util.View;
import jm.util.Write;

import abc.notation.BarLine;
import abc.notation.KeySignature;
import abc.notation.Note;
import abc.notation.TimeSignature;
import abc.notation.Tune;
import abc.ui.swing.JScoreComponent;


public class SmArtsGarden implements JMC{
	long time1, time2;
	Long[] times;
	String strTimes;
	static Score score = new Score("Sax", ALTO_SAXOPHONE);
	Part sax = new Part("Saxaphone", ALTO_SAXOPHONE, 1);
	Phrase phr = new Phrase("Saxaphone");
	
	//Constructor for SmArts Garden
	SmArtsGarden(){
//		phr.setTitle("Sax");
//		try{
//		time1 = System.nanoTime();
//		URL url = new URL("http://facebook.com");
//		URLConnection connection = url.openConnection();
//		connection.getContent();
//		time2 = System.nanoTime();
		times = new Long[24];
////		times[0] = (""+(time2-time1)+"");
//		times[0] = time2-time1;
//		
//		}
//		catch(MalformedURLException e){
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		strTimes = times[0].toString();
//		System.out.println(strTimes);
//		System.out.println(time1);
		
		Tune tune = new Tune();
		KeySignature key = new KeySignature(abc.notation.Note.C, KeySignature.MAJOR);
        tune.getMusic().addElement(key);
        Tune.Music music = tune.getMusic();
        
		for(int i = 0; i < times.length; i++){
			
			times[i] = getGoogleStat(i);
			System.out.println(times[i]);
			if (i == 0){
				music.addElement(new TimeSignature(4,4)	 );
				
			}
			if (i%4 == 0 && i != 0){
				music.add(new BarLine());
			}
		
		int num = valueAtPosition(times[i], 1);
		System.out.println(num);
		if(num == 0 || num == 1){
			Note n1 = new Note(Note.c);
			n1.setStrictDuration(Note.QUARTER);

//			Note n1 = new Note(C4, QUARTER_NOTE);
			music.addElement(n1);
//			phr.add(n1);
//			Play.midi(phr);
//			wait(500);
		}
		if(num == 2 || num == 3){
//			Note n1 = new Note(D4, QUARTER_NOTE);
			Note n1 = new Note(Note.D);
			n1.setStrictDuration(Note.QUARTER);

			music.addElement(n1);
//			phr.add(n1);
//			Play.midi(phr);
//			wait(500);
		}
		if(num == 4 || num == 5){
//			Note n1 = new Note(E4, QUARTER_NOTE);
			Note n1 = new Note(Note.E);
			n1.setStrictDuration(Note.QUARTER);

			music.addElement(n1);
//			phr.add(n1);
//			Play.midi(phr);
//			wait(500);

		}
		if(num == 6  || num == 7){
//			Note n1 = new Note(G4, QUARTER_NOTE);
			Note n1 = new Note(Note.G);
			n1.setStrictDuration(Note.QUARTER);

			music.addElement(n1);

//			phr.add(n1);
//			Play.midi(phr);
//			wait(500);

		}
		if(num == 8 || num == 9){
//			Note n1 = new Note(A4, QUARTER_NOTE);
			Note n1 = new Note(Note.A);
			n1.setStrictDuration(Note.QUARTER);

			music.addElement(n1);

//			phr.add(n1);
//			Play.midi(phr);
//			wait(500);
			

		}
//		i = times.length;
		}
		
//		sax.add(phr);
//		score.add(sax);
//		View.notate(score, 500, 500);
//		Write.xml(score, "score.xml");
		
		JScoreComponent scoreUI = new JScoreComponent();
		scoreUI.setTune(tune);
		JFrame j = new JFrame();
		j.add(scoreUI);
		j.pack();
		j.setVisible(true);
		
		
		
		
//		ShowScore shower = new ShowScore(score, 300, 300);
//		
//		
//		GrandStave stave = new GrandStave(phr);
//		stave.setVisible(true);
		
		
//		Play.midi(phr);
//		long bleh = times[0]/100000;
		
//		System.out.println(bleh);
//		prints each digit of a long for testing
//		char[] eachDigit;
//		eachDigit = strTimes.toCharArray();
//		for(int i = 0; i<strTimes.length(); i++){
//			System.out.println(eachDigit[i]);
//			char a = eachDigit[0];
//			int one = Character.getNumericValue(a);
//		}
		
		
	}
	public void numberHolder(){
		
	}
	public static void main(String[] args){
		new SmArtsGarden();
//		Applet theApplet = new SmArtsGarden();
//		Frame theFrame = new Frame();
//		theFrame.setSize(300, 300);
//		theFrame.add(theApplet);;
//		theApplet.init();
//		theApplet.start();
//		theFrame.setVisible(true);
	}
	public int valueAtPosition(Long l, int position){
		int forReturn;
		char [] eachDigit;
		eachDigit = l.toString().toCharArray();
		forReturn = Character.getNumericValue(eachDigit[position]);
//		System.out.println(eachDigit[position]);
		
		return forReturn;
	}
	
	public long getGoogleStat(int timePos){
		URL url;
		int pos = timePos;
//		System.out.println(pos);
		try {
			url = new URL("http://google.com");
			time1 = System.nanoTime();
			URLConnection connection;
			connection = url.openConnection();
			connection.getContent();
			time2 = System.nanoTime();
			
			
//			new WriteToFile().writeToFile("myFile.txt", time);
//			FileWrite(time,true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time2-time1;
//		System.out.println("Time to load Google = " + time + " nanoseconds.");
		
	}
	
}
