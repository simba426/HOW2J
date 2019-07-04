import com.sun.tools.javac.comp.Check;

import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HOW2J {

    public static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }

    public static void main(String[] argv) {
        String randomStr = randomString(3);
        List<String> passwords = new ArrayList<>();

        new HackPasswordThread(randomStr, passwords).start();
        new LogPasswordThread(passwords).start();

    }
}







