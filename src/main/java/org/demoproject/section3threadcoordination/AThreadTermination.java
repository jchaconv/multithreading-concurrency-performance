package org.demoproject.section3threadcoordination;

public class AThreadTermination {

    public static void main(String[] args) {

        Thread thread = new Thread(new BlockingTask());
        thread.start(); //solo con esto se queda esperando

        thread.interrupt(); //termina el thread y la aplicación

    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            //do things
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }



}
