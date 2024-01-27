package twothreads;

// Напишите программу, которая каждую секунду отображает на экране данные о времени,
// прошедшем от начала сессии (запуска программы).
//
// Другой ее поток выводит каждые 5 секунд сообщение "Прошло 5 секунд".
// Предусмотрите возможность ежесекундного оповещения потока,
// воспроизводящего сообщение, потоком, отсчитывающим время.

public class ThreadDemo {

    public static void main(String[] args) {

        Thread first = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Прошло 5 секунд");
            }
        });
        Thread second = new Thread(() -> {
            while (true) {
                System.out.println("Прошла 1 секунда");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        first.start();
        second.start();
    }
}