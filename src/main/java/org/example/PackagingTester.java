package org.example;

public class PackagingTester extends Tester {
    @Override
    protected boolean validate( Product product ) {
        return ( product.packaging() == "HEALTHY" || product.packaging() == "ALMOST_HEALTHY" )
                ? nextValidationFor( product )
                : false;
    }
}
