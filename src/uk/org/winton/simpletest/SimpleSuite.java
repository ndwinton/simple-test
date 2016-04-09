package uk.org.winton.simpletest;


/**
 * Created by Admin on 08/04/2016.
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
