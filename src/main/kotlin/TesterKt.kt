abstract class TesterKt {
    var nextTester: TesterKt
        get() {
            return nextTester
        }
        set(tester: TesterKt) {
            nextTester = tester
        }

    abstract fun validate(productKt: ProductKt): Boolean
}