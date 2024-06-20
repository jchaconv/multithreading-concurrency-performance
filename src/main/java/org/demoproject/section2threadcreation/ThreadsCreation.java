package org.demoproject.section2threadcreation;

public class ThreadsCreation {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("We are now in Thread " + Thread.currentThread().getName());
            System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
        });

        thread.setName("new-worker-thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in Thread " + Thread.currentThread().getName() + " before starting a new Thread");
        thread.start();
        System.out.println("We are in Thread " + Thread.currentThread().getName() + " after starting a new Thread");

        Thread.sleep(10000);

    }


}
