package org.demoproject.section3threadcoordination;

import java.math.BigInteger;

public class BThreadTermination2 {

    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000000000"), new BigInteger("1000000000")));
        thread.start(); //Solo con esta línea y valores como 1 y 2 si se procesan pero con valores muy grandes nunca termina el proceso
        thread.interrupt(); //por eso se agrega esta línea para terminar el thread y la aplicación
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
                //Se agregó esta validación para que se pueda interrumpir el thread
                if(Thread.currentThread().isInterrupted()) {    //Se valida el Interrupt Signal
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }

    }


}
