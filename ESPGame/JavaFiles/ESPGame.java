/*
 * Class: CMSC203 	
 * Instructor: David Kuijt
 * Description: Write a program that tests your ESP (extrasensory perception). Create 
a list of the five names of colors. The program should randomly select the name of a color from
your list of words.
 * Due: 09/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Rodney Coit
*/

import java.util.Scanner;
import java.util.Random;

public class ESPGame {

	
	public static void main(String[] args) {
		
		//Scanner class instance
		Scanner sc = new Scanner(System.in);
		
		//Random class instance
		Random rand = new Random();
		
		//Constants
		final String RED = "Red";
		final String GREEN = "Green";
		final String BLUE = "Blue";
		final String ORANGE = "Orange";
		final String YELLOW = "Yellow";
		
		//counter for correct guesses
		int correctGuesses = 0;
		//upper bound for random number
		int upperBound = 5;
		//generate random number
		int randNum = rand.nextInt(upperBound);
		//generate random guess of color according to random number
		String randGuess = "";
		
		//Ask user's name
		System.out.print("Enter your name: ");
		//name variable
		String name = sc.nextLine();
		
		//Ask user to describe themselves
		System.out.print("Describe yourself: ");
		//description variable
		String desc = sc.nextLine();
		
		//Ask user the due date
		System.out.print("Due Date: ");
		//due date variable
		String due = sc.nextLine();
		
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		
		//ask user for their guess and tell them the random color
		int i = 0;
	
		for (i = 0; i < 11; i++) {
			boolean flag = false;
				System.out.println("Round " + (i+1));
				System.out.println(System.lineSeparator());
				System.out.println("I am thinking of a color.");
				System.out.println("Is it Red, Green, Blue, Orange, or Yellow?");
				System.out.println("Enter your guess:");
				String guess = sc.nextLine();
			
				System.out.println(System.lineSeparator());

		//switch statement assigns random number to a color
			switch(randNum) {
			case 0:
				randGuess = RED;
				break;
			case 1:
				randGuess = GREEN;
				break;
			case 2:
				randGuess = BLUE;
				break;
			case 3:
				randGuess = ORANGE;
				break;
			case 4:
				randGuess = YELLOW;
			default: break;
		}
			//test all correct colors
			if (guess.equalsIgnoreCase(RED)) {
				flag = true;
				System.out.println("I was thinking of " + randGuess + ".");
				if (guess.equalsIgnoreCase(randGuess)) {
					correctGuesses++;
				}
				
			}
			else if (guess.equalsIgnoreCase(GREEN)) {
				flag = true;
				System.out.println("I was thinking of " + randGuess + ".");
				if (guess.equalsIgnoreCase(randGuess)) {
					correctGuesses++;
				}
			}
			else if (guess.equalsIgnoreCase(BLUE)) {
				flag = true;
				System.out.println("I was thinking of " + randGuess + ".");
				if (guess.equalsIgnoreCase(randGuess)) {
					correctGuesses++;
				}
			}
			else if (guess.equalsIgnoreCase(ORANGE)) {
				flag = true;
				System.out.println("I was thinking of " + randGuess + ".");
				if (guess.equalsIgnoreCase(randGuess)) {
					correctGuesses++;
				}
			}
			else if (guess.equalsIgnoreCase(YELLOW)) {
				flag = true;
				System.out.println("I was thinking of " + randGuess + ".");
				if (guess.equalsIgnoreCase(randGuess)) {
					correctGuesses++;
				}
			}
			else {
				while (!flag) {
				//input validation if color entered is not a color
					System.out.println("You entered an incorrect color. Is it Red, Green,"
						+ " Blue, Orange, or Yellow?");
					System.out.println("Enter your guess again:");
					guess = sc.nextLine(); 
				
					if (guess.equalsIgnoreCase(RED)) {
						flag = true;
						System.out.println("I was thinking of " + randGuess + ".");
						if (guess.equalsIgnoreCase(randGuess)) {
							correctGuesses++;
						}
						
					}
					else if (guess.equalsIgnoreCase(GREEN)) {
						flag = true;
						System.out.println("I was thinking of " + randGuess + ".");
						if (guess.equalsIgnoreCase(randGuess)) {
							correctGuesses++;
						}
					}
					else if (guess.equalsIgnoreCase(BLUE)) {
						flag = true;
						System.out.println("I was thinking of " + randGuess + ".");
						if (guess.equalsIgnoreCase(randGuess)) {
							correctGuesses++;
						}
					}
					else if (guess.equalsIgnoreCase(ORANGE)) {
						flag = true;
						System.out.println("I was thinking of " + randGuess + ".");
						if (guess.equalsIgnoreCase(randGuess)) {
							correctGuesses++;
						}
					}
					else if (guess.equalsIgnoreCase(YELLOW)) {
						flag = true;
						System.out.println("I was thinking of " + randGuess + ".");
						if (guess.equalsIgnoreCase(randGuess)) {
							correctGuesses++;
						}
					}
				}
			}
			//generate new random number for next round
			randNum = rand.nextInt(upperBound);
		}
		//display user info
		System.out.println("Game Over");
		System.out.println(System.lineSeparator());
		System.out.println("You guessed " + correctGuesses + " out of 10 colors correctly.");
		System.out.println("User Name: " + name);
		System.out.println("User Description: " + desc);
		System.out.println("Due Date: " + due);
	}

}
