package Vehicles;

import utils.Pair;

public class Car implements Vehicle{
    final Pair DIMENSION = new Pair(3, 3);
    @Override
    public Pair getAreaDimensions() {
        return DIMENSION;
    }
}
