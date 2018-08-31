import java.util.Scanner;

import jm.JMC;

public class Convert implements JMC {
	static Scanner reader = new Scanner(System.in);
	static StringToMIDI stm = new StringToMIDI();
	static int i;

	public static void main(String[] args) {
		do {
			System.out.println("...");
			System.out.println("1. Create .mid file by giving a string");
			System.out.println("2. Read .mid file to a string");
			System.out.println("3. Show .mid file");
			System.out.println("4. Exit");
			i = reader.nextInt();
			switch (i) {
			case 1:
				stm.toMIDI();
				break;
			case 2:
				stm.toLine();
				break;
			case 3:
				stm.showMIDI();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("No such number in the menu!");
				break;
			}

		} while (i != 4);
	}

}
