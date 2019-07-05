import oracle.jvm.hotspot.jfr.Producer;

public class CosumerAndProducer {
    static class ConsumerThread extends Thread{
        private String name;
        private MyStack<Character> stack;

        public ConsumerThread (String name, MyStack stack) {
            this.name = name;
            this.stack = stack;
        }

        @Override
        public void run() {
            while (true) {
                Character s = this.stack.pull();
                System.out.printf("%s : 取出字符: %s%n", this.name, s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ProducerThread extends Thread{
        String name;
        MyStack<Character> stack;

        public ProducerThread (String name, MyStack<Character> stack) {
            this.name = name;
            this.stack = stack;
        }

        @Override
        public void run() {
            while (true) {
                char c = generateupperLetter();
                stack.push(c);
                System.out.printf("%s : 放入字符: %s%n", this.name, c);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public char generateupperLetter() {
            char[] c = new char[26];
            int index = 0;
            for (short i = 'A'; i <= 'Z'; i++)
                c[index++] = (char) i;
            int random = (int) (Math.random() * 25);
            return c[random];
        }
    }

    public void test() {
        MyStack<Character> stack = new MyStack<>();
        ProducerThread p1 = new ProducerThread("Producer 1", stack);
        ProducerThread p2 = new ProducerThread("Producer 2", stack);
        ConsumerThread c1 = new ConsumerThread("Consumer 1", stack);
        ConsumerThread c2 = new ConsumerThread("Consumer 2", stack);
        ConsumerThread c3 = new ConsumerThread("Consumer 3", stack);
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
    }

}
