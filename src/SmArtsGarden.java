import java.applet.Applet;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JWindow;

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

import abc.midi.BasicMidiConverter;
import abc.midi.MidiConverterAbstract;
import abc.midi.TunePlayer;
import abc.notation.BarLine;
import abc.notation.KeySignature;
import abc.notation.Note;
import abc.notation.TimeSignature;
import abc.notation.Tune;
import abc.ui.swing.JScoreComponent;

/**  
 * Generates music based on the statistics gathered about web site load times.
 * 
 * @author spensermorgan
 * 
 */
public class SmArtsGarden extends JFrame implements ActionListener, JMC {
	long time1, time2;
	Long[] times, stats1;
	int numsites = 48; 
	double[] norms = new double[numsites];
	
	int i;
	// ArrayList netstats = new ArrayList();

	String strTimes;
	static Score score = new Score("Sax", ALTO_SAXOPHONE);
	Part sax = new Part("Saxaphone", ALTO_SAXOPHONE, 1);
	Phrase phr = new Phrase("Saxaphone");
	TunePlayer player = new TunePlayer();
	Tune tune = new Tune();

	/**
	 * Constructor for SmArtsGarden
	 */
	public SmArtsGarden(){

		// NetStats stats = new NetStats();
		// String stat = stats.getSite();
		// System.out.println(stat);
		// phr.setTitle("Sax");
		// try{
		// time1 = System.nanoTime();
		// URL url = new URL("http://facebook.com");
		// URLConnection connection = url.openConnection();
		// connection.getContent();
		// time2 = System.nanoTime();
		NetStats stats = new NetStats();

		times = stats.siteStats(stats, numsites);
		stats1 = new Long[numsites];
//		Container c = new Container();
//		c.ggetContentPanel();
//		
//		JWindow pop = new JWindow();
//		
		JFrame frame = new JFrame();
		frame.setSize(500, 100);
		frame.setLocation(100, 400);
		frame.setLayout(new FlowLayout());
		JLabel f1 = new JLabel("Would you like to play the song now?");
		frame.add(f1);
		JButton button1 = new JButton("Play live.");
		button1.addActionListener(this);
		frame.add(button1);
		frame.setVisible(true);
		double[] normal = normalizer(times);
		for(long i : times)
			System.out.println(i);
		
		KeySignature key = new KeySignature(abc.notation.Note.C,
				KeySignature.MAJOR);
		tune.getMusic().addElement(key);
		Tune.Music music = tune.getMusic();
//		music.setSize(24);
		// music.addElement(arg0)
		pitchChooser(music, normal);
//		

		// sax.add(phr);
		// score.add(sax);
		// View.notate(score, 500, 500);
		// Write.xml(score, "score.xml");
		// System.out.println()
		// music.trimToSize(24);
		JScoreComponent scoreUI = new JScoreComponent();
		scoreUI.setTune(tune);
		JFrame j = new JFrame();
		j.add(scoreUI);
		j.pack();
		j.setVisible(true);
//		TunePlayer player = new TunePlayer();
		
		// starts the player and play the tune
		player.start();
//		player.play(tune);
		// The midi file result
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateStr = sdf.format(cal.getTime());
//		cal.getTime()
		File file = new File("test"+cal.getTime()+".mid");
		// Create a converter to convert a tune into midi sequence
		MidiConverterAbstract conv = new BasicMidiConverter();
		// convert it !
		Sequence s = conv.toMidiSequence(tune);
		// All available midi file type for the tune's sequence
		int[] types = MidiSystem.getMidiFileTypes(s);
		// Write the sequence as a midi file.
		try {
			MidiSystem.write(s, types[0], file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TunePlayer() player = new TunePlayer();
		// player.play(tune);

		// ShowScore shower = new ShowScore(score, 300, 300);
		//
		//
		// GrandStave stave = new GrandStave(phr);
		// stave.setVisible(true);

		// long bleh = times[0]/100000;

		// System.out.println(bleh);
		// prints each digit of a long for testing
		// char[] eachDigit;
		// eachDigit = strTimes.toCharArray();
		// for(int i = 0; i<strTimes.length(); i++){
		// System.out.println(eachDigit[i]);
		// char a = eachDigit[0];
		// int one = Character.getNumericValue(a);
		// }

	}
	public void actionPerformed (ActionEvent e){
		System.out.println("playing");
//		player.start();
		player.play(tune);
			
	}

	public static void main(String[] args) {
		new SmArtsGarden();
		// Applet theApplet = new SmArtsGarden();
		// Frame theFrame = new Frame();
		// theFrame.setSize(300, 300);
		// theFrame.add(theApplet);;
		// theApplet.init();
		// theApplet.start();
		// theFrame.setVisible(true);
	}
/**
 * 
 * @param l Long - a stored value of the time it took to load a website.
 * @param position (decimal place) of a digit in the Long (tens, hundreds, thousands place) 
 * @return a single integer value based on the position that is passed in parameters.
 */
	public int valueAtPosition(Long l, int position) {
		int forReturn;
		char[] eachDigit;
		eachDigit = l.toString().toCharArray();
		forReturn = Character.getNumericValue(eachDigit[position]);
		// System.out.println(eachDigit[position]);

		return forReturn;
	}

	

	/**
	 * 
	 * @param inum (should be the same as the beat position in the total score)
	 * 
	 * @return the duration each note. In the generated score
	 * a note of a longer length means that it took longer to load the content from the URL.
	 */
	public short durationPicker(int inum) {
		short rhythm = Note.EIGHTH;
		inum = i;
		if (valueAtPosition(times[inum], 0) == 0) {
			// rhythm = "WHOLE";
			// i = i+4;
			return Note.EIGHTH;
		} else if (valueAtPosition(times[inum], 0) <= 4) {
			// rhythm = "HALF";
			// i = i+2;
			return Note.QUARTER;

		} else if (valueAtPosition(times[inum], 0) <= 9) {
			// rhythm = "QUARTER";
			// i = i+1;
			return Note.HALF;
		}

		return rhythm;

	}
	/**
	 * 
	 * @param inum
	 * @param normal - array of doubles normalized from the times array using normalizer();
	 * @return the rhythm value to be played depending on the speed of page load times. 
	 */
	public short durationPicker1(int inum, double[] normal) {
		short rhythm = Note.HALF;
		inum = i;
		if (normal[inum] == 0) {
			// rhythm = "WHOLE";
			// i = i+4;
			return Note.SIXTEENTH;
		} else if (normal[inum] <= .3) {
			// rhythm = "HALF";
			// i = i+2;
			return Note.SIXTEENTH;

		} else if (normal[inum] <= .4) {
			// rhythm = "QUARTER";
			// i = i+1;
			
			
			return Note.EIGHTH;
		} else if (normal[inum] <= .6){
			return Note.QUARTER;
			
		} else if (normal[inum] <= .9){
			return Note.WHOLE;
		} else{
			return rhythm;
		}
		

//		return rhythm;

	}
	public double[] normalizer(Long[] statArray){
		Long[] ary=statArray.clone();
		double[] normAry = new double[statArray.length];
		long high = 0, current;
		
		for(int x = 0; x < ary.length;x++){
			current = ary[x];
			if (high < current){
				high = current;
			}
		}
		double highest = (double)high;
//		System.out.println("Max value is:" + highest);
		
		for (i = 0; i < ary.length; i++){
			normAry[i] = (double)ary[i]/(highest);
//			System.out.println(normAry);
		}
		return normAry;
	}

	public void pitchChooser(Tune.Music music, double[] normal){
		for (i = 0; i < times.length; i++) {

			// times[i] = getGoogleStat(i);
			// System.out.println(times[i]);
			// if (i == 0){
			// music.addElement(new TimeSignature(4,4) );
			//
			// }
			// if (i%4 == 0 && i != 0){
			// music.add(new BarLine());
			// }
			int num;
			if(times[i] > 10){
			num = valueAtPosition(times[i], 1);
			}
			else{
			num = valueAtPosition(times[i], 0);
			}
			System.out.println(num);
			if (num == 0 || num == 1) {
				Note n1 = new Note(Note.C);
				
				// n1.setStrictDuration(Note.QUARTER);
				//
				n1.setStrictDuration(durationPicker1(i, normal));
//				music.set(1, PENTATONIC_SCALE);
//				music.addElement()

				// Note n1 = new Note(C4, QUARTER_NOTE);
				music.addElement(n1);
				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);
			}
			if (num == 2 || num == 3) {
				// Note n1 = new Note(D4, QUARTER_NOTE);
				Note n1 = new Note(Note.D);
				// n1.setStrictDuration(Note.QUARTER); 
				n1.setStrictDuration(durationPicker1(i, normal));

				music.addElement(n1);
				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);
			}
			if (num == 4 || num == 5) {
				// Note n1 = new Note(E4, QUARTER_NOTE);
				Note n1 = new Note(Note.E);
				// n1.setStrictDuration(Note.QUARTER);
//				n1.setStrictDuration(durationPicker1(i));
				n1.setStrictDuration(durationPicker1(i, normal));


				music.addElement(n1);
				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);

			}
			if (num == 6 || num == 7) {
				// Note n1 = new Note(G4, QUARTER_NOTE);
				Note n1 = new Note(Note.G);
				// n1.setStrictDuration(Note.QUARTER);
//				n1.setStrictDuration(durationPicker(i));
				n1.setStrictDuration(durationPicker1(i, normal));

				music.addElement(n1);

				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);

			}
			if (num == 8 || num == 9) {
				// Note n1 = new Note(A4, QUARTER_NOTE);
				Note n1 = new Note(Note.A);
				// n1.setStrictDuration(Note.QUARTER);
//				n1.setStrictDuration(durationPicker(i));
				n1.setStrictDuration(durationPicker1(i, normal));


				music.addElement(n1);

				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);

			}
			// i = times.length;
		}
	}

}
