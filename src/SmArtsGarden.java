import java.applet.Applet;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
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
 * @author spensermorgan
 *
 */
public class SmArtsGarden implements JMC {
	long time1, time2;
	Long[] times;
	int i;
	// ArrayList netstats = new ArrayList();

	String strTimes;
	static Score score = new Score("Sax", ALTO_SAXOPHONE);
	Part sax = new Part("Saxaphone", ALTO_SAXOPHONE, 1);
	Phrase phr = new Phrase("Saxaphone");

	// Constructor for SmArts Garden
	SmArtsGarden() {

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

		times = stats.siteStats(stats, 48);
		Tune tune = new Tune();
		KeySignature key = new KeySignature(abc.notation.Note.C,
				KeySignature.MAJOR);
		tune.getMusic().addElement(key);
		Tune.Music music = tune.getMusic();
		music.setSize(24);
		// music.addElement(arg0)
		pitchChooser(music);
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
		TunePlayer player = new TunePlayer();
		// starts the player and play the tune
		player.start();
		player.play(tune);
		// The midi file result
		File file = new File("test.mid");
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

		// Play.midi(phr);
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

	public void numberHolder() {

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
	
	public void pitchChooser(Tune.Music music){
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

			int num = valueAtPosition(times[i], 2);
			System.out.println(num);
			if (num == 0 || num == 1) {
				Note n1 = new Note(Note.C);
				// n1.setStrictDuration(Note.QUARTER);
				//
				n1.setStrictDuration(durationPicker(i));

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
				n1.setStrictDuration(durationPicker(i));

				music.addElement(n1);
				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);
			}
			if (num == 4 || num == 5) {
				// Note n1 = new Note(E4, QUARTER_NOTE);
				Note n1 = new Note(Note.E);
				// n1.setStrictDuration(Note.QUARTER);
				n1.setStrictDuration(durationPicker(i));

				music.addElement(n1);
				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);

			}
			if (num == 6 || num == 7) {
				// Note n1 = new Note(G4, QUARTER_NOTE);
				Note n1 = new Note(Note.G);
				// n1.setStrictDuration(Note.QUARTER);
				n1.setStrictDuration(durationPicker(i));

				music.addElement(n1);

				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);

			}
			if (num == 8 || num == 9) {
				// Note n1 = new Note(A4, QUARTER_NOTE);
				Note n1 = new Note(Note.A);
				// n1.setStrictDuration(Note.QUARTER);
				n1.setStrictDuration(durationPicker(i));

				music.addElement(n1);

				// phr.add(n1);
				// Play.midi(phr);
				// wait(500);

			}
			// i = times.length;
		}
	}

}
