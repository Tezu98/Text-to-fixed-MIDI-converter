import java.util.HashMap;
import java.util.Scanner;

import jm.constants.Durations;
import jm.constants.Pitches;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Read;
import jm.util.View;
import jm.util.Write;

public class StringToMIDI {
	private static Scanner reader = new Scanner(System.in);
	private static char[] alphabet = "abcdefghijklmnoprstuwvxyzq1234567890., !?/-".toCharArray();
	private static HashMap<Character, Note> notes = new HashMap<Character, Note>();
	private static HashMap<Integer, Character> chars = new HashMap<Integer, Character>();
	private static int[] pitch = { Pitches.A1, Pitches.AS1, Pitches.B1, Pitches.C2, Pitches.CS2, Pitches.D2,
			Pitches.DS2, Pitches.E2, Pitches.F2, Pitches.FS2, Pitches.G2, Pitches.GS2, Pitches.A2, Pitches.AS2,
			Pitches.B2, Pitches.C3, Pitches.CS3, Pitches.D3, Pitches.DS3, Pitches.E3, Pitches.F3, Pitches.FS3,
			Pitches.G3, Pitches.GS3, Pitches.A3, Pitches.AS3, Pitches.B3, Pitches.C4, Pitches.CS4, Pitches.D4,
			Pitches.DS4, Pitches.E4, Pitches.F4, Pitches.FS4, Pitches.G4, Pitches.GS4, Pitches.A4, Pitches.AS4,
			Pitches.B4, Pitches.C5, Pitches.CS5, Pitches.D5, Pitches.DS5};
	private static double d = Durations.Q;

	static {
		for (int i = 0; i < pitch.length; i++) {
			Note n = new Note(pitch[i], d);
			notes.put(alphabet[i], n);
			chars.put(pitch[i], alphabet[i]);
		}
	}

	public static void toMIDI() {
		System.out.print("Podaj Nazwê plikuj: ");
		if (reader.hasNextLine()) {
			String fileName = reader.nextLine();
			System.out.print("Podaj ci¹g znaków: ");
			Phrase phr = new Phrase();
			Part p = new Part();
			Score s = new Score();

			char[] line = reader.nextLine().toCharArray();
			for (int i = 0; i < line.length; i++) {
				System.out.println(line[i] + " " + notes.get(line[i]));
				phr.add(notes.get(line[i]));
			}
			p.addPhrase(phr);
			s.addPart(p);
			Write.midi(s, fileName + ".mid");
		}
	}

	public static void showMIDI() {
		System.out.print("Podaj Nazwê pliku: ");
		String fileName = reader.nextLine();

		Score s = new Score(fileName);
		Read.midi(s, fileName + ".mid");
		View.show(s);
	}

	public static void toLine() {

		System.out.print("Podaj Nazwê pliku: ");
		String fileName = reader.nextLine();
		Part p = new Part();
		Phrase ph = new Phrase(0.0);
		Score s = new Score();
		Read.midi(s, fileName + ".mid");

		p = s.getPart(0);
		ph = p.getPhrase(0);
		for (int i = 0; i < ph.getNoteArray().length; i++) {
			System.out.print(chars.get(ph.getNote(i).getPitch()));
		}
	}
}
