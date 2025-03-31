
import java.util.Random;
public class Die {
    private int numSides;
    private int currentValue;
    private Random generator = new Random();
    private static final int DEFAULT_SIDES = 6;
    private static final int NO_MORE_THAN_HUNDRED = 100;

    public Die(int numSides){
        this.currentValue = generator.nextInt(numSides) + 1;
        this.numSides = numSides;
        if (this.numSides < 2 || this.numSides > NO_MORE_THAN_HUNDRED){
            this.numSides = DEFAULT_SIDES;
        }
    }

    public int getCurrentValue(){
        return currentValue;
    }

    public void roll(){
        currentValue = generator.nextInt(numSides) + 1;
    }
}

