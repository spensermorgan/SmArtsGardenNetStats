import jm.JMC;
//import jm.JMC.*;
import jm.music.data.*;
import jm.midi.*;
import jm.util.*; 
public class Chimes implements JMC{
	public static void main(String[] args){
		Part part = new Part("All Chimes", BELLS, 0);
		int[] pitchSet = {C6, F6, G5, D7};
		for(int i = 0; i<pitchSet.length; i++){
			Phrase phr = new Phrase((double)i);
			for(int j=0; j<24;j++){
				Note note = new Note(pitchSet[1],Math.random()*8,
						(int)(Math.random() *80+20));
				phr.addNote(note);		
			}
			part.addPhrase(phr);
		}
	View.notate(part);
		Play.midi(part);
		
	}
}
