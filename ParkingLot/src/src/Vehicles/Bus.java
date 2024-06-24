package Vehicles;

import utils.Pair;

public class Bus implements Vehicle{
    final Pair DIMENSION = new Pair(4, 5);
    @Override
    public Pair getAreaDimensions() {
        return DIMENSION;
    }
}
