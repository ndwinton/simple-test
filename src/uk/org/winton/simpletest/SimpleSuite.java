package uk.org.winton.simpletest;

/**
 * Created by Neil Winton (neil@winton.org.uk).
 *
 * This code is in the public domain. Do with it as you will!
 */
public abstract class SimpleSuite {

    public abstract void run();

    public static void assertThat(String message, boolean condition) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public void test(String name, Runnable method) {
        System.out.print(name);
        try {
            method.run();
            System.out.println(" - OK");
        }
        catch (AssertionError ae) {
            System.out.println(" - FAIL: " + ae.getMessage());
        }
        catch (Exception e) {
            System.out.println(" - EXCEPTION: " + e);
        }
    }
}
