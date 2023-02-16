abstract class Tester {
    var nextTester: Tester
        get() {
            return nextTester
        }
        set(tester: Tester) {
            nextTester = tester
        }

    abstract fun test(KProduct: Product): Boolean
}