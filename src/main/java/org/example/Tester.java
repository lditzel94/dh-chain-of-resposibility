package org.example;

public abstract class QA {

    private QA nextTester;

    protected abstract boolean validate( Product product );

    public QA getNextTester() {
        return nextTester;
    }

    public void setNextTester( QA nextTester ) {
        this.nextTester = nextTester;
    }
}
