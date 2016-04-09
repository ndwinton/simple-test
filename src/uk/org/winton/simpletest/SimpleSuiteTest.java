package uk.org.winton.simpletest;

/**
 * Created by Neil Winton (neil@winton.org.uk).
 *
 * This code is in the public domain. Do with it as you will!
 */
public class SimpleSuiteTest extends SimpleSuite {
    public static final int THE_ANSWER = 42;

    @Override
    public void run() {
        test("Simplest possible successful test", () -> assertThat("true is true", true));

        test("Calling a local method", this::localTestMethod);

        test("Failure is captured", () -> assertThat("it fails as expected", false));

        test("Exceptions are handled differently", () -> { throw new RuntimeException("whoa!"); });

        test("Exceptions handled in local methods", this::localExceptionMethod);

        test("You could do things the old-fashioned way", new Runnable() {
            @Override
            public void run() {
                assertThat("old still works", true);
            }
        });
    }

    void localTestMethod() {
        assertThat("42 is the answer", 42 == THE_ANSWER);
    }

    void localExceptionMethod() throws IllegalStateException {
        throw new IllegalStateException("exception state");
    }

    public static void main(String[] args) {
        new SimpleSuiteTest().run();
    }
}
