class TestQualityKt(
    val tester: TesterKt
) {
    fun validateQualityOf(productKt: ProductKt): String =
        productKt.validate()

    private fun ProductKt.validate() =
        if (tester.validate(this)) "Aceptado"
        else "Rechazado"

}