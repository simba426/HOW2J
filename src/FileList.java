import java.io.File;

public class FileList {
    public static void run() {
        File f = new File("/Users/simba/Documents");
        File[] files = f.listFiles();
        if (null == files)
            return;
        long minLength = Integer.MAX_VALUE;
        long maxLength = 0;
        File maxFile = null;
        File minFile = null;
        for (File file: files) {
            if (file.isDirectory())
                continue;
            if (file.length() > maxLength) {
                maxLength = file.length();
                maxFile = file;
            }
            if (file.length() != 0 && file.length() < minLength) {
                minLength = file.length();
                minFile = file;
            }
        }
        System.out.printf("最大的文件是%s,其大小是%d字节", maxFile.getAbsolutePath(), maxLength);
        System.out.printf("最小的文件是%s,其大小是%d字节", minFile.getAbsolutePath(), minLength);
    }
}
