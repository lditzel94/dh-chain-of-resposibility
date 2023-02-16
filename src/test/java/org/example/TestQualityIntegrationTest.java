package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestQualityIntegrationTest {

    private BatchTester batchTester;
    private WeightTester weightTester;
    private PackagingTester packagingTester;
    private TestQuality qualityTester;

    @BeforeEach
    void setup() {
        batchTester = new BatchTester();
        weightTester = new WeightTester();
        packagingTester = new PackagingTester();

        batchTester.setNextTester( weightTester );
        weightTester.setNextTester( packagingTester );

        qualityTester = new TestQuality( batchTester );
    }

    @Test
    @DisplayName( "Should validate successfully" )
    void validateQualityOf() {
        //Arrange
        var product = new Product(
                "Pantuflas",
                1100,
                1250,
                "HEALTHY"
        );

        //Act
        var result = qualityTester.validateQualityOf( product );

        //Assert
        assertEquals( "Aceptado", result );
    }

    @Nested
    @DisplayName( "Should fail validation" )
    class FailValidation {
        @Test
        @DisplayName( "Should fail batch validation" )
        void batchFails() {
            //Arrange
            var product = new Product(
                    "Pantuflas",
                    900,
                    1250,
                    "HEALTHY"
            );

            //Act
            var result = qualityTester.validateQualityOf( product );

            //Assert
            assertEquals( "Rechazado", result );
        }

        @Test
        @DisplayName( "Should fail weight validation" )
        void weightFails() {
            //Arrange
            var product = new Product(
                    "Pantuflas",
                    1100,
                    1000,
                    "HEALTHY"
            );

            //Act
            var result = qualityTester.validateQualityOf( product );

            //Assert
            assertEquals( "Rechazado", result );
        }

        @Test
        @DisplayName( "Should fail packaging validation" )
        void packagingFails() {
            //Arrange
            var product = new Product(
                    "Pantuflas",
                    1100,
                    1250,
                    "NOT_HEALTHY"
            );

            //Act
            var result = qualityTester.validateQualityOf( product );

            //Assert
            assertEquals( "Rechazado", result );
        }
    }
}