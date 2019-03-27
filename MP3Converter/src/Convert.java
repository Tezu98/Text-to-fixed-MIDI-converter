import java.util.Scanner;

import jm.JMC;

public class Convert implements JMC {
	static Scanner reader = new Scanner(System.in);
	static int i;

	public static void main(String[] args) {
		do {
			System.out.println("");
			System.out.println("1. Create MIDI file by providing ");
			System.out.println("2. PLACEHOLDER");
			System.out.println("3. READ .mid file");
			System.out.println("4. Exit");
			i = reader.nextInt();
			switch (i) {
			case 1:
				StringToMIDI.toMIDI();
				break;
			case 2:
				StringToMIDI.toLine();
				break;
			case 3:
				StringToMIDI.showMIDI();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Error: Wrong number provided");
				break;
			}

		} while (i != 4);
	}
}
