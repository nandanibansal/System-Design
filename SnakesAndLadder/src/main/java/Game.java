import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players= new LinkedList<>();
    Player winner;

    public void initialiseGame(int boardSize){
       board = new Board(boardSize, 4, 3);
       dice = new Dice(1);
       winner = null;
       addPlayers();
    }

    public void addPlayers(){
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame(){
        while (winner==null){
            Player playerTurn = findPlayerFirst();
            System.out.println("Player turn is:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);

            int moves = dice.rollDice();

            int playerNewPosition = playerTurn.currentPosition + moves;
            playerNewPosition = jumpCheck(playerNewPosition);

            if(playerNewPosition == players.getFirst().currentPosition){
                players.getFirst().currentPosition = 1;
            }

            playerTurn.setCurrentPosition(playerNewPosition);

            System.out.println("Player turn is:" + playerTurn.id + " new Position is: " + playerNewPosition);
            if(playerNewPosition >= board.cells.length * board.cells.length-1){

                winner = playerTurn;
            }
        }
        System.out.println("WINNER IS:" + winner.id);
    }

    Player findPlayerFirst(){
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }

    int jumpCheck(int playerNewPosition){
        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.startPosition == playerNewPosition) {
            String jumpBy = (cell.jump.startPosition < cell.jump.endPosition)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.endPosition;
        }
        return playerNewPosition;
    }
}
