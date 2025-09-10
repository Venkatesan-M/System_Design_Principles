package LLD.SnakeAndLadder;

import java.util.*;

public class GameBoard {
    Dice dice;
    Queue<Player> players;
    List<Jumper> snakses;
    List<Jumper> ladders;
    Map<String, Integer> playerPositions;
    int boardSize;

    GameBoard(Dice dice, Queue<Player> players, List<Jumper> snakses, List<Jumper> ladders, int boardSize) {
        this.dice = dice;
        this.players = players;
        this.snakses = snakses;
        this.ladders = ladders;
        this.boardSize = boardSize;
        this.playerPositions = new HashMap<>();
        for (Player player : players) {
            playerPositions.put(player.name, 0);
        }
    }

    void startGame() {
        while (players.size() > 1) {
            Player currentPlayer = players.poll();
            int currentPosition = playerPositions.get(currentPlayer.name);
            int diceValue = dice.roll();
            int newPosition = currentPosition + diceValue;
            boolean bittenBySnake = false;
            boolean takenLadder = false;
            int actualPosition = newPosition;
            if (newPosition > boardSize) {
                newPosition = currentPosition;
            } else {
                for (Jumper ladder : ladders) {
                    if (ladder.start == newPosition) {
                        newPosition = ladder.end;
                        bittenBySnake = true;
                        break;
                    }
                }
                for (Jumper snake : snakses) {
                    if (snake.start == newPosition) {
                        newPosition = snake.end;
                        takenLadder = true;
                        break;
                    }
                }
            }
            playerPositions.put(currentPlayer.name, newPosition);
            System.out.println(currentPlayer.name + " rolled a " + diceValue + " and moved from " + currentPosition + " to " + actualPosition);
            if(bittenBySnake){
                System.out.println(currentPlayer.name + " bitten by a snake and moved from " + actualPosition + " to " + newPosition);
            }
            if(takenLadder){
                System.out.println(currentPlayer.name + " took a ladder and moved from " + actualPosition + " to " + newPosition);
            }
            if (newPosition == boardSize) {
                System.out.println(currentPlayer.name + " has won the game!");
            } else {
                players.offer(currentPlayer);
            }
        }
        if (!players.isEmpty()) {
            System.out.println(players.peek().name + " is the last player remaining.");
        }
    }
}
