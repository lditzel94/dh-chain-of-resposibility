package org.example;

public class BatchTester extends Tester {
    @Override
    protected boolean validate( Product product ) {
        return product.batch() >= 1000 && product.batch() <= 2000
                ? nextValidationFor( product )
                : false;
    }
}
