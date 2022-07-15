/**
 * <pre>
 * 任务：
 * 描述：(这里用一句话描述这个类的作用)
 * 作者：
 * 时间：
 * </pre>
 */

public class Test01 {

    private static  Object resource1 = new Object();//资源1
    private static  Object resource2 = new Object();//资源2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized(resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"线程1").start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 2").start();
    }
}
