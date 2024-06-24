package Vehicles;

import utils.Pair;

public class Bike implements Vehicle{
    final Pair DIMENSION = new Pair(2, 3);
    @Override
    public Pair getAreaDimensions() {
        return DIMENSION;
    }
}
