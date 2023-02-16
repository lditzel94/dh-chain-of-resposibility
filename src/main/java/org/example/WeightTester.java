package org.example;

public class WeightTester extends Tester {
    @Override
    protected boolean validate( Product product ) {
        return product.weight() >= 1200 && product.weight() <= 1300
                ? getNextTester().validate( product )
                : false;
    }
}
