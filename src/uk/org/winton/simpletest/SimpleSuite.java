package uk.org.winton.simpletest;

/**
 * Created by Neil Winton (neil@winton.org.uk).
 *
 * This code is in the public domain. Do with it as you will!
 */
public abstract class SimpleSuite {
    private int passes = 0;
    private int fails = 0;
    private int errors = 0;
    
    public abstract void specification();
    
    public void run() {
        passes = fails = errors = 0;
        specification();
        System.out.println("Total number of tests: " + (passes + fails + errors) +
                ", Passes: " + passes + ", Fails: " + fails + ", Errors: " + errors);
    }

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
            passes++;
        }
        catch (AssertionError ae) {
            System.out.println(" - FAIL: " + ae.getMessage());
            fails++;
        }
        catch (Exception e) {
            System.out.println(" - EXCEPTION: " + e);
            errors++;
        }
    }
    
    public int getPasses() {
        return passes;
    }

    public int getFails() {
        return fails;
    }

    public int getErrors() {
        return errors;
    }
}
