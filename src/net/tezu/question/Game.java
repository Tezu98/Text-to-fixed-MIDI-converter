package net.tezu.question;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private int score, tryes;

	private ArrayList<Question> questions = null;
	private Scanner reader = new Scanner(System.in);

	private void createQuestions() {

		questions = new ArrayList<Question>();

		Question q1 = new Question("Kim jest?", "Gidel");
		Question q2 = new Question("Jak jest", "Dobrze");
		String test = reader.nextLine();

		questions.add(q1);
		questions.add(q2);
	}

	private void newQuestion(){
		String answer;
		do {
		for(int i = 0; i < questions.size();) {
			System.out.println(questions.get(i).getQuestion());
			answer = reader.nextLine();
			if(answer.equals(questions.get(i).getAnswer())){
				score += 10;
				i++;
				System.out.println("Odpowiedz poprawna");
				System.out.println("Ilo�� punkt�w: " + score);
			}else {
				score -= 5;
				tryes--;
				System.out.println("B��dna odpowiedz, pozosta�o " + tryes + " pr�b");
			} 
			if(i >= questions.size()){
				tryes = 0;
				System.out.println("Wygra�e�, tw�j wynik: " + score);
			}
		}
		}while(tryes > 0);
		
	}

	public void startGame() {
		createQuestions();
		score = 0;
		tryes = 3;

		newQuestion();
	}

}
