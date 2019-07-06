package multiplethread;

import java.util.ArrayList;
import java.util.List;

public class LogPasswordThread extends Thread {

    private List<String> passwords;

    public LogPasswordThread(List<String> passwords) {
        this.passwords = passwords;
        this.setDaemon(true);
    }

    public void run() {
        while (true) {
            while (passwords.isEmpty()) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String s = passwords.remove(0);
            System.out.printf("此次生成的密码是:%s%n", s);
        }
    }
}
