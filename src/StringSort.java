import java.util.Arrays;

/**
 * 创建一个长度是8的字符串数组
 * 使用8个长度是5的随机字符串初始化这个数组 对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)
 * 注1： 不能使用Arrays.sort() 要自己写
 * 注2： 无视大小写，即 Axxxx 和 axxxxx 没有先后顺序
 * 排序使用冒泡法
 */

public class StringSort {

    public static void sort() {
        String[] str = new String[10];
        for (int i = 0; i < 10; i++) {
            String s = randomString(5);
            str[i] = s;
        }
        for (int j = 0; j < str.length; j++)
            for (int i = 0; i < str.length - j - 1; i++){
                char character1 = str[i].charAt(0);
                char character2 = str[i + 1].charAt(0);
                character1 = Character.toLowerCase(character1);
                character2 = Character.toLowerCase(character2);
                if (character1 > character2){
                    String temp = str[i];
                    str[i] = str[i + 1];
                    str[i + 1] = temp;
                }
            }
        System.out.println(Arrays.toString(str));
    }

    public static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++)
            pool += (char)i;
        for (short i = 'a'; i <= 'z'; i++)
            pool += (char)i;
        for (short i = 'A'; i <= 'Z'; i++)
            pool += (char)i;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * pool.length());
            result[i] = pool.charAt(index);
            //System.out.println(result[i]);
        }
        String res = new String(result);
        return res;
    }
}
