import java.util.*;
public class TicTacToe {
public static void main(String[] args) {
		
		System.out.println("Welcome to play TicTacToe game! "
				+ "We have the following 3 x 3 empty board.");
		
		String[][] board=new String [3][3];
		String original="-";
				
		for (int i=0;i<board.length;i++) {
			for (int j=0;j<board.length;j++)
			board[i][j]=original;
				
		
		} 
		
		printBoard(board);
		playGame(board);
		
	} 
			//printing an empty board
			static void printBoard(String [][]board) {
				System.out.println(" --- --- --- ");
			
				System.out.println(": " + board[0][0] + " : " + board[0][1] + " : " + board[0][2] + " :");
				System.out.println(":-----------:");
				System.out.println(": " + board[1][0] + " : " + board[1][1] + " : " + board[1][2] + " :");
				System.out.println(":-----------:");
				System.out.println(": " + board[2][0] + " : " + board[2][1] + " : " + board[2][2] + " :");
				System.out.println(" --- --- --- ");
			}                                                                           
			
			//playing the game
			static void playGame(String [][] board) {
				int counter=1;
				String X= "X";
				String O="O";
				String winner=null;
				int row;
				int column;
				
				Scanner input=new Scanner(System.in);
				
				System.out.println("X will go first, O next");
				
				
				while (winner==null) {
					
					for (int i=0;i<board.length;i++) {
						
					System.out.print("enter the row number: ");
						row=input.nextInt();
					
					System.out.print("enter the column number: ");
						column=input.nextInt();
						
						//if the place is already taken, repeat. 
						while (board[row][column]!="-") {
							System.out.println("this position is already taken");
							System.out.print("enter the row number: ");
							row=input.nextInt();
						
						System.out.print("enter the column number: ");
							column=input.nextInt();
						}
						
					counter++;
					
					//determing which player's turn it is
					if(column<3 && counter%2==0) {
						board[row][column]=X;
						printBoard(board);
					}
					if (column<3 && counter%2!=0) {
						board[row][column]=O;
						printBoard(board);
					}
					if (counter>=4) {
						winnerCheck(board);
					}
					// if no winner is determined, its automatically a tie. 
					if (counter==10) {
							winner="Its a draw!";	
							System.out.println(winner);
							System.exit(1);
						}	
				}	
					 	
							
			}	
			}	

	//checking for a winner
	static void winnerCheck(String [][]board) {
		String winner=null;
		
		for (int i=0;i<7;i++) {
			String win=null;
			switch(i) {
			case 0:
				win=board[0][0]+ board[0][1] + board[0][2];
				break;
			case 1:
				win=board[1][0] + board[1][1] +  board[1][2];
				break;
			case 2:
				win=board[2][0] + board[2][1] +  board[2][2];
				break;
			case 3:
				win=board[0][0] + board[1][1] +  board[2][2];
				break;
			case 4:
				win=board[0][2] + board[1][1] +  board[2][0];
				break;
			case 5:
				win=board[0][0] + board[1][0] +  board[2][0];
				break;
			case 6:
				win=board[0][1] + board[1][1] +  board[2][1];
				break;
			case 7:
				win=board[0][2] + board[1][2] +  board[2][2];
				break;
			}
			
			
		if(win.equals("XXX")) {
			winner="Winner is X!";
			System.out.println(winner);
			System.exit(1);
			
		} else if (win.equals("OOO")) {
			winner="Winner is O!";
			System.out.println(winner);
			System.exit(1);
			
		}
		
		}
		
			
	}
}