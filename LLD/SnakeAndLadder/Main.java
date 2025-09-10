package LLD.SnakeAndLadder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Dice with 6 faces
        Dice dice = new Dice(6);

        // Players
        Queue<Player> players = new LinkedList<>();
        players.add(new Player(1, "Alice"));
        players.add(new Player(2, "Bob"));
        players.add(new Player(3, "Charlie"));

        // Snakes
        List<Jumper> snakes = new ArrayList<>();
        snakes.add(new Jumper(99, 10));
        snakes.add(new Jumper(90, 50));
        snakes.add(new Jumper(75, 32));
        snakes.add(new Jumper(60, 22));

        // Ladders
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(new Jumper(5, 25));
        ladders.add(new Jumper(20, 40));
        ladders.add(new Jumper(35, 70));
        ladders.add(new Jumper(55, 90));

        // Board Size
        int boardSize = 100;

        // Initialize game
        GameBoard game = new GameBoard(dice, players, snakes, ladders, boardSize);

        // Start game
        game.startGame();
    }
}
