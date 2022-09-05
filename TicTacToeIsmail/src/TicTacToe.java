import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
	static ArrayList<Integer> player2Positions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	
	public static void main(String[] args) {

		//CREATING THE GAMEBOARD
		char[][] gameBoard = {
				{ ' ' , '|' , ' ' , '|', ' ' },
				{ '-' , '+' , '-' , '+', '-' },
				{ ' ' , '|' , ' ' , '|', ' ' },
				{ '-' , '+' , '-' , '+', '-' },
				{ ' ' , '|' , ' ' , '|', ' ' }};

				printGameBoard(gameBoard);

				
				// IMPORTING A SCANNER CALLED ''sc'' THAT TAKES IN THE USERS INPUT
				Scanner sc = new Scanner(System.in);
				
				while(true) {
					// ASKING THE USER TO ENTER THEIR POSITION
					System.out.println("Enter your position (1-9:");
					
					//PLAYER 1
					int player1Pos = sc.nextInt();
					while(player1Positions.contains(player1Pos) || player2Positions.contains(player1Pos)) {
						System.out.println("Position already taken, enter another position");
						player1Pos = sc.nextInt();
					}
					placePiece(gameBoard, player1Pos, "player 1");
					printGameBoard(gameBoard);
					String winner = checkWinner();
					System.out.println(winner);

					//PLAYER 2
					int player2Pos = sc.nextInt();
					while(player2Positions.contains(player2Pos) || player1Positions.contains(player2Pos)) {
						System.out.println("Position already taken, enter another position");
						player2Pos = sc.nextInt();
					}
					placePiece(gameBoard, player2Pos, "player 2");
					printGameBoard(gameBoard);

					//CPU (ALTERNATIVE)
						//Random rand = new Random();
						//int cpuPos = rand.nextInt(9) + 1;
						//while(cpuPositions.contains(cpuPos) || player1Positions.contains(cpuPos)) {
						//System.out.println("Position already taken, enter another position");
						//cpuPos = sc.nextInt();
						//placePiece(gameBoard, cpuPos, "CPU");
						//printGameBoard(gameBoard);
						//}
				
				
					System.out.println(winner);
				}
				
				
		}
		
		// CREATING A METHOD SO THE PROGRAM DONT RUN IN THE MAIN METHOD
		public static void printGameBoard(char[][] gameBoard) {

		// USING FOR-EACH TO PRINT OUT THE GAMEBOARD	
		for ( char[] row : gameBoard) {
			for (char c : row) {
				//PRINTING THE WHOLE GAMEBOARD ON A ROW
				System.out.print(c);
			}
			//PRINTING OUT EMPTY LINES TO BREAK THE ROWS
			System.out.println();
			
			
		}
	}
	
		// CREATING A METHOD FOR THE SWITCH CASE FOR THE CODE TO BE MORE CLEAN
		public static void placePiece(char[][] gameBoard, int pos, String user) {
			
			char symbol = ' ';
			
			if (user.equals("player 1")) {
				symbol = 'X';
				player1Positions.add(pos);
			} else if (user.equals("player 2")) {
				symbol = 'O';
				player2Positions.add(pos);
			}
			
			// USING SWITCH CASE TO PLACE THE USERS INPUT ON THE BOARD
			switch (pos) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
				
				default:
					break;

			}
		}
		
		// CREATING A METHOD TO CHECK THE WINNER
		public static String checkWinner() {
			
			// SEPERATE EVERY WINNING CONDITION IN LISTS
			List topRow = Arrays.asList(1,2,3);
			List midRow = Arrays.asList(4,5,6);
			List botRow = Arrays.asList(7,8,9);
			List leftCol = Arrays.asList(1,4,7);
			List midCol = Arrays.asList(2,5,8);
			List rightCol = Arrays.asList(3,6,9);
			List cross1 = Arrays.asList(1,5,9);
			List cross2 = Arrays.asList(3,5,7);

			List<List> winningConditions = new ArrayList<List>();
			winningConditions.add(topRow);
			winningConditions.add(midRow);
			winningConditions.add(botRow);
			winningConditions.add(leftCol);
			winningConditions.add(midCol);
			winningConditions.add(rightCol);
			winningConditions.add(cross1);
			winningConditions.add(cross2);
			
			for (List list : winningConditions) {
				if (player1Positions.containsAll(list)) {
					return "Congrats, PLAYER 1 won!";
				} else if (player2Positions.containsAll(list)) {
					return "Congrats, PLAYER 2 won!";
				} else if (player1Positions.size()+player2Positions.size()==9) {
					return "It's a TIE";
				}
			}




			return "";
		}
	

}
