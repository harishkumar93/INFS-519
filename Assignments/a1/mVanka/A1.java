
/**
 * @author Manikanta Harish Kumar Vanka	#G01029523
 * INFS 519
 * Spring 2017
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Assignment 1 : Program to inspect the CS Honor Code.
 */

public class A1 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		int num = 0; // create an integer variable to read input from command line.
		String filename = null; //create a string variable to send the filename as command line argument.
		
				if (args.length == 0) { //checks if the command line argument is passed or not.
						System.out.println("Specify a filename as Command Line Argument to print the Honor code.\n");
						System.exit(0);
					}		
					else {
						filename=args[0];
					}
		
		String csHonorCode = "CS Honor Code Policies\n(Source: {http://cs.gmu.edu/resources/honor-code/})\n\nAll CS students must adhere to the GMU Honor Code. In addition to this honor code, the computer science department has further honor code policies regarding programming projects, which is detailed below. Your instructor may state further policies for his or her class as well.\n\nUnless otherwise stated, at the time that an assignment or project is given, all work handed in for credit is to be the result of individual effort.(In some classes group work is encouraged; if so, that will be made explicit when the assignment is given.)\n";
		
		String menuOptions = "Select an option from the following menu:\n\n 1) View contents: You (or your group, if a group assignment) may... \n\n 2) View contents: You (or your group, if a group assignment) may not seek assistance from anyone else, other than your instructor or teaching assistant... \n\n 3) View contents: Unless permission to do so is granted by the instructor, you (or your group, if a group assignment) may not... \n\n 4) View contents: You must... \n\n 5) Print the honor code to "+filename +"\n\n 6) Quit";
		
		String option1 = "\n1) You (or your group, if a group assignment) may:\n\n\t  * seek assistance in learning to use the computing facilities;\n\t  * seek assistance in learning to use special features of a programming language's implementation;\n\t  * seek assistance in determining the syntactic correctness of a particular programming language statement or construct;\n\t  * seek an explanation of a particular syntactic error;\n\t  * seek explanations of compilation or run-time error messages\n";

		String option2 = "\n2) You (or your group, if a group assignment) may not seek assistance from anyone else, other than your instructor or teaching assistant:\n\n\t * in designing the data structures used in your solution to a problem;\n\t * in designing the algorithm to solve a problem; \n\t * in modifying the design of an algorithm determined to be faulty; \n\t * in implementing your algorithm in a programming language;\n\t * in correcting a faulty implementation of your algorithm\n\t * in determining the semantic correctness of your algorithm." + "\n";

		String option3 = "\n3) Unless permission to do so is granted by the instructor, you (or your group, if a group assignment) may not \n\n\t * give a copy of your work in any form to another student;\n\t * receive a copy of someone else's work in any form;\n\t * attempt to gain access to any files other than your own or those authorized by the instructor or computer center;\n\t * inspect or retain in your possession another student's work, whether it was given to you by another student, it was found after other student has discarded his/her work, or it accidently came into your possession;\n\t * in any way collaborate with someone else in the design or implementation or logical revision of an algorithm;\n\t * present as your own, any algorithmic procedure which is not of your own or of the instructor's design, or which is not part of the course's required reading (if you modify any procedure which is presented in the course's texts but which is not specifically mentioned in class or covered in reading assignments, then a citation with page number must be given);\n\t * incorporate code written by others (such as can be found on the Internet);\n";

		String option4 = "\n4) You must:\n\n\t * report any violations of II and III that you become aware of.\n\t * if part of a group assignment, be an equal partner in your group's activities and productions, and represent accurately the level of your participation in your group's activities and productions.\n";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(csHonorCode); // Printing CS Honor Code

			do {
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				System.out.println(menuOptions); // Printing Menu												
				System.out.println("-----------------------------------------------------------------------------------------------------------\n");
				System.out.print("What do you want to do?\t");

					try {
						num = Integer.parseInt(br.readLine());
						}
					catch (NumberFormatException nfe)
						{
						System.err.println("\nInvalid Format!");
						num = 0;
						}

				switch (num) // passing input into switch case
					{
					case 1: {
						System.out.println(option1);
						break;
					}
					case 2: {
						System.out.println(option2);
						break;
					} 
					case 3: {
						System.out.println(option3);
						break;
					}
					case 4: {
						System.out.println(option4);
						break;
					}
					case 5: {

						PrintWriter printWriter = new PrintWriter(filename, "UTF-8"); // To print the output to a text file.
						printWriter.println(csHonorCode);
						printWriter.println(option1);
						printWriter.println(option2);
						printWriter.println(option3);
						printWriter.println(option4);
						printWriter.close();
						System.out.println("\nGMU CS honor code is printed to " + filename + "\n");
						break;
					}
					case 6: {
						System.out.println("Good Bye!");
						break;
					}
					default: {
						System.out.println("\nThis is not a valid selection\n"); // print this statement if the input contains invalid characters.
					}
				}// end of switch case
		} while (num != 6); //end of do-while loop
	}// end of main class
}// end of A1 class