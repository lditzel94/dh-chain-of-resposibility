import extensions.isInBetween

class WeightTester : Tester() {
    override fun test(product: Product): Boolean =
        product.validate()

    private fun Product.validate() =
        if (weight.isInBetween(1200, 1300))
            nextTester.test(this)
        else false
}