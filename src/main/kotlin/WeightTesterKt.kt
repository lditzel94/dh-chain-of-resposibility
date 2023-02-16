import extensions.isInBetween

class WeightTesterKt : TesterKt() {
    override fun validate(productKt: ProductKt): Boolean =
        productKt.validate()

    private fun ProductKt.validate() =
        if (weight.isInBetween(1200, 1300))
            nextTester.validate(this)
        else false
}