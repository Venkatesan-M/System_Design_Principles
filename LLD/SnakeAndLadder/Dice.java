package LLD.SnakeAndLadder;

public class Dice {
    int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int roll() {
        return (int) (Math.random() * (6 * numberOfDice - 1 * numberOfDice) + 1);
    }
}
