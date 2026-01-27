import Enums.GameStatus;
import PlayingItems.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import Enums.PieceType;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;
    Player winner;

    public void initialiseGame(){
        players = new LinkedList<>();
        PlayingPiece crossPiece = new PlayingPieceX();
        PlayingPiece circlePiece = new PlayingPiece(Enums.PieceType.O);
        Player player1 = new Player("Player 1", crossPiece);
        Player player2 = new Player("Player 2", circlePiece);
        players.add(player1);
        players.add(player2);
        board = new Board(3);
    }

    public GameStatus startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player currentPlayer = players.removeFirst();
            board.printBoard();
            List<Pair> freeCells = board.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner = true;
                continue;
            }

            System.out.println(currentPlayer.name+ " - Please enter your move (row, column): ");
            Scanner scannerInput = new Scanner(System.in);
            String s = scannerInput.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);

            boolean validMove = board.addPiece(inputRow, inputCol, currentPlayer.playingPiece);
            if(!validMove){
                System.out.println("Incorrect position chosen, try again!");
                players.addFirst(currentPlayer);
                continue;
            }

            players.addLast(currentPlayer);
            boolean isWinner = checkForWinner(inputRow, inputCol, currentPlayer.playingPiece.pieceType);
            if(isWinner){
                board.printBoard();
                winner = currentPlayer;
                return GameStatus.WIN;
            }
        }
        return GameStatus.NO_WIN;
    }
    public boolean checkForWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check Row
        for (int i = 0; i < board.size; i++) {
            if (board.board[row][i] == null || board.board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        // Check Column
        for (int i = 0; i < board.size; i++) {
            if (board.board[i][column] == null || board.board[i][column].pieceType != pieceType) {
                columnMatch = false;
                break;
            }
        }

        // Check Diagonally
        for (int i = 0, j = 0; i < board.size; i++, j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Anti-Diagonally
        for (int i = 0, j = board.size - 1; i < board.size; i++, j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }

}
