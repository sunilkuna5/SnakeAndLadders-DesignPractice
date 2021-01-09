package Game.GameComponents;

import java.util.Random;

public class DiceImpl implements Dice {

    private final int sides;
    Random random;

    public DiceImpl(int sides) {
        this.sides = sides;
        random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(sides)+1;
    }

    @Override
    public int getSides() {
        return sides;
    }
}
