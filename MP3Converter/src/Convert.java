import java.util.Scanner;

import jm.JMC;

public class Convert implements JMC {
	static Scanner reader = new Scanner(System.in);
	static int i;

	public static void main(String[] args) {
		do {
			System.out.println("");
			System.out.println("1. Stwórz plik MIDI poprzez podanie ci¹gu znaków");
			System.out.println("2. Odczytaj plik midi poprzez podanie nazwy pliku");
			System.out.println("3. Poka¿ plik .mid");
			System.out.println("4. Wyjdz");
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
				System.out.println("B³êdny numer proszê zrestartowaæ program!");
				break;
			}

		} while (i != 4);
	}

}
