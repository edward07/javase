package thread;

import java.util.ArrayList;
import java.util.List;

public class TestMemoryLeak {

    public static void main(String[] args) throws InterruptedException {
        List<SimpleObject> list = new ArrayList<>();
        Runtime run = Runtime.getRuntime();
        int i = 1;

        while (true) {
            SimpleObject simpleObject = new SimpleObject();
            list.add(simpleObject);
            simpleObject = null;

            if (i++ % 1000 == 0) {
                System.out.print(i + ": 最大内存=" + run.maxMemory() / 1024 / 1024 + "M,");
                System.out.print("已分配内存=" + run.totalMemory() / 1024 / 1024 + "M,");
                System.out.print("剩余空间内存=" + run.freeMemory() / 1024 / 1024 + "M");
                System.out.println("最大可用内存=" + (run.maxMemory() - run.totalMemory() + run.freeMemory()) / 1024 / 1024 + "M");
            }

            Thread.sleep(1);
        }
    }

    static class SimpleObject {
        // 初始化占用1M内存的数组
        private int[] arr = new int[1024 * 8];
        public int[] getArr() {
            return arr;
        }
    }

}
