class PackagingTester : Tester() {
    override fun test(product: Product): Boolean =
        with(product) {
            packaging.isValid()
        }

    private fun String.isValid() =
        if (equals("HEALTHY") || equals("ALMOST_HEALTHY")) true
        else false


}