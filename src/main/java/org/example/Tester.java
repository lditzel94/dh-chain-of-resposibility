package org.example;

public abstract class Tester {

    private Tester nextTester;

    protected abstract boolean validate( Product product );

    public Tester getNextTester() {
        return nextTester;
    }

    public void setNextTester( Tester nextTester ) {
        this.nextTester = nextTester;
    }
}
