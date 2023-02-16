package org.example;

import java.util.Optional;

import static org.example.ValidateTester.validateFor;

public abstract class Tester {

    private Tester nextTester;

    protected abstract boolean validate( Product product );

    protected boolean nextValidationFor( Product product ) {
        return Optional.ofNullable( nextTester )
                       .map( validateFor( product ) )
                       .orElse( true );
    }

    public void setNextTester( Tester nextTester ) {
        this.nextTester = nextTester;
    }
}
