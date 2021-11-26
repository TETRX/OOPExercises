package agh.ics.oop;

import java.util.Random;

public class PseudorandomRandomnessSource implements RandomnessSource{
    private Random random;
    public PseudorandomRandomnessSource(){
        random = new Random();
    }
    @Override
    public int randInt(int l, int r) {
        return random.nextInt(r)+l;
    }
}
