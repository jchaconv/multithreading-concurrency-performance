package org.demoproject.section3threadcoordination;

import java.math.BigInteger;

public class ThreadDaemon {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000000000"), new BigInteger("1000000000")));
        thread.setDaemon(true); //Lo establezco como una daemon Thread
        thread.start();

        //Para terminar el main-thread en 1000ms y comprobar que termina la aplicación
        //entera sin esperar el final del daemon thread
        Thread.sleep(1000);

        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "ˆ" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {

                result = result.multiply(base);
            }

            return result;
        }

    }


}
