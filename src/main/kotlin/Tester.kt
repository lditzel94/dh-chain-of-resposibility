abstract class Tester {
    var nextTester: Tester
        get() {
            return nextTester
        }
        set(KTester: Tester) {
            nextTester = KTester
        }

    abstract fun test(KProduct: Product): Boolean
}