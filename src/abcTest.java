import javax.swing.JFrame;

import abc.notation.KeySignature;
import abc.notation.Note;
import abc.notation.Tune;
import abc.ui.swing.JScoreComponent;

public class abcTest{

public static void main (String[] arg) {
        Tune tune = new Tune();
        KeySignature key = new KeySignature(Note.D, KeySignature.MAJOR);
        tune.getMusic().addElement(key);
        Tune.Music music = tune.getMusic();
        music.addElement(new Note(Note.C));
        music.addElement(new Note(Note.D));
        music.addElement(new Note(Note.E));
        music.addElement(new Note(Note.F));
        music.addElement(new Note(Note.G));
        music.addElement(new Note(Note.A));
        music.addElement(new Note(Note.B));
        music.addElement(new Note(Note.c));
        music.addElement(new Note(Note.d));
        music.addElement(new Note(Note.e));
        music.addElement(new Note(Note.f));
        music.addElement(new Note(Note.g));
        music.addElement(new Note(Note.g));
        music.addElement(new Note(Note.f));
        music.addElement(new Note(Note.e));
        music.addElement(new Note(Note.d));
        music.addElement(new Note(Note.c));
        music.addElement(new Note(Note.B));
        music.addElement(new Note(Note.A));
        music.addElement(new Note(Note.G));
        music.addElement(new Note(Note.F));
        music.addElement(new Note(Note.E));
        music.addElement(new Note(Note.D));
        music.addElement(new Note(Note.C));
        JScoreComponent scoreUI =new JScoreComponent();
        scoreUI.setTune(tune);
        JFrame j = new JFrame();
        j.add(scoreUI);
        j.pack();
        j.setVisible(true);
}

}