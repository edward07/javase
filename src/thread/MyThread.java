package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThread {

    BlockingQueue<Runnable> workQueue;

    List<WorkerThread> threads = new ArrayList<>();

    public MyThread(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i = 0; i < poolSize; i++) {
            WorkerThread wt = new WorkerThread();
            wt.start();
            threads.add(wt);
        }
    }

    public void execute(Runnable command) throws Exception {
        workQueue.put(command);
    }

    class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = workQueue.take();
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(2);
        MyThread pool = new MyThread(10, workQueue);
        pool.execute(() -> {
            System.out.printf("hello");
        });
    }

}


