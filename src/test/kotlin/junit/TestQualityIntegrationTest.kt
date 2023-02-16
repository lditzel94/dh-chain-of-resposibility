package junit

import BatchTester
import PackagingTester
import Product
import TestQuality
import WeightTester
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS

class TestQualityIntegrationTest {

    private lateinit var batchTester: BatchTester
    private lateinit var weightTester: WeightTester
    private lateinit var packagingTester: PackagingTester
    private lateinit var qualityTester: TestQuality

    @BeforeEach
    fun setup() {
        batchTester = BatchTester()
        weightTester = WeightTester()
        packagingTester = PackagingTester()

        batchTester.nextTester = weightTester
        weightTester.nextTester = packagingTester
        qualityTester = TestQuality(batchTester)
    }

    @Test
    fun `should validate successfully`() {
        //given
        val product = Product(
            name = "Pantuflas",
            batch = 1100,
            weight = 1250,
            packaging = "HEALTHY"
        )

        //when
        val result = qualityTester.validateQualityOf(product)

        //then
        assertEquals("Aceptado", result)
    }

    @Nested
    @DisplayName("should fail validation")
    @TestInstance(PER_CLASS)
    inner class FailValidation {

        @Test
        fun `should fail batch validation`() {
            //Arrange
            val product = Product(
                name = "Pantuflas",
                batch = 900,
                weight = 1250,
                packaging = "HEALTHY"
            )

            //Act
            val result = qualityTester.validateQualityOf(product)

            //Assert
            assertEquals("Rechazado", result)
        }

        @Test
        fun `should fail weight validation`() {
            //Arrange
            val product = Product(
                name = "Pantuflas",
                batch = 1100,
                weight = 1000,
                packaging = "HEALTHY"
            )

            //Act
            val result = qualityTester.validateQualityOf(product)

            //Assert
            assertEquals("Rechazado", result)
        }

        @Test
        @DisplayName("Should fail packaging validation")
        fun packagingFails() {
            //Arrange
            val product = Product(
                name = "Pantuflas",
                batch = 1100,
                weight = 1250,
                packaging = "NOT_HEALTHY"
            )

            //Act
            val result = qualityTester.validateQualityOf(product)

            //Assert
            assertEquals("Rechazado", result)
        }
    }
}