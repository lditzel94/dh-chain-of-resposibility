import extensions.isInBetween

class BatchTesterKt : TesterKt() {
    override fun validate(productKt: ProductKt): Boolean =
        productKt.validate()


    private fun ProductKt.validate() =
        if (batch.isInBetween(1000, 2000))
            nextTester.validate(this)
        else false
}