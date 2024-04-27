package test;

import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class JunitTest4 {
    @Test
    public void test() {
        System.out.println("Hello from JunitTest4...");
    }

    @Test
    public void testAdd() {
        int a = 1;
        int b = 2;
        int c = a + b;
        assertEquals("加法测试失败", 4, c);
    }

    @Test(timeout = 1000)
    public void testTimeout() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
