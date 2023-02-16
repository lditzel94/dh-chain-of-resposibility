package org.example;

import java.util.Optional;

import static org.example.ValidateTester.validateFor;

public class WeightTester extends Tester {
    @Override
    protected boolean validate( Product product ) {
        return product.weight() >= 1200 && product.weight() <= 1300
                ? Optional.ofNullable( getNextTester() )
                          .map( validateFor( product ) )
                          .orElse( true )
                : false;
    }
}
