package replace_with_four_threads;

class FizzBuzz {
    private int n;
    private int num = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }


    public synchronized void fizz() {
        while (num <= n) {
            if (num % 3 == 0 && num % 5 != 0) {
                System.out.println("fizz");
                num++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public synchronized void buzz() {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 == 0) {
                System.out.println("buzz");
                num++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzBuzz() {
        while (num <= n) {
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.println("fizzbuzz");
                num++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void number() {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 != 0) {
                System.out.println(num);
                num++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args){
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread treadA = new Thread(() -> fizzBuzz.fizz());
        Thread threadB = new Thread(() -> fizzBuzz.buzz());
        Thread threadC = new Thread(() -> fizzBuzz.fizzBuzz());
        Thread treadD = new Thread(() -> fizzBuzz.number());
        treadA.start();
        threadB.start();
        threadC.start();
        treadD.start();
    }
}