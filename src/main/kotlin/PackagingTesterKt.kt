class PackagingTesterKt : TesterKt() {
    override fun validate(productKt: ProductKt): Boolean =
        with(productKt) {
            packaging.isValid()
        }

    private fun String.isValid() =
        if (equals("HEALTHY") || equals("ALMOST_HEALTHY")) true
        else false


}