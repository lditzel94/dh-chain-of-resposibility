package org.example;

import java.util.Optional;

import static org.example.ValidateTester.validateFor;

public class BatchTester extends Tester {
    @Override
    protected boolean validate( Product product ) {
        return product.batch() >= 1000 && product.batch() <= 2000
                ? Optional.ofNullable( getNextTester() )
                          .map( validateFor( product ) )
                          .orElse( true )
                : false;
    }

}
