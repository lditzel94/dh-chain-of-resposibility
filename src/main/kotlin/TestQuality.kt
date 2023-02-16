class TestQuality(
    val tester: Tester
) {
    fun validateQualityOf(KProduct: Product): String =
        KProduct.validate()

    private fun Product.validate() =
        if (tester.test(this)) "Aceptado"
        else "Rechazado"

}