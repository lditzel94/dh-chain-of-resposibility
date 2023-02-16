package org.example;

public class Main {
    public static void main( String[] args ) {
        var product = new Product(
                "Pantuflas",
                1100,
                1250,
                "HEALTHY"
        );
        var batchTester = new BatchTester();
        var weightTester = new WeightTester();
        var packagingTester = new PackagingTester();

        batchTester.setNextTester( weightTester );
        weightTester.setNextTester( packagingTester );

        var tester = new TestQuality( batchTester );
        System.out.println( "Resultado del test de calidad: " + tester.validateQualityOf( product ) );
    }
}