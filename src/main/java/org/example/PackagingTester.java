package org.example;

import java.util.Optional;

import static org.example.ValidateTester.validateFor;

public class PackagingTester extends Tester {
    @Override
    protected boolean validate( Product product ) {
        return ( product.packaging() == "HEALTHY" || product.packaging() == "ALMOST_HEALTHY" )
                ? Optional.ofNullable( getNextTester() )
                          .map( validateFor( product ) )
                          .orElse( true )
                : false;
    }
}
