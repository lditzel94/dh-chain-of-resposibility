import extensions.isInBetween

class BatchTester : Tester() {
    override fun test(product: Product): Boolean =
        product.validate()


    private fun Product.validate() =
        if (batch.isInBetween(1000, 2000))
            nextTester.test(this)
        else false
}