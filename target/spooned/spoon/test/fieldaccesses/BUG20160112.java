package spoon.test.fieldaccesses;


public class BUG20160112 {
    spoon.test.fieldaccesses.BUG20160112 a;

    int us;

    public void test() {
        int z = 0;
        z += a.us;
        return;
    }
}

