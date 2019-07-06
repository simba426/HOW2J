package file;

import java.io.File;

public class FileList {
    private long minLength = Integer.MAX_VALUE;
    private long maxLength = 0;
    private File maxFile = null;
    private File minFile = null;

    public void maxAndMin(File f) {
        if (f.isFile()) {
            if (f.length() > maxLength) {
                maxLength = f.length();
                maxFile = f;
            }
            if (f.length() != 0 && f.length() < minLength) {
                minLength = f.length();
                minFile = f;
            }
        }

        if (f.isDirectory()){
            File[] files = f.listFiles();
            if (null != files)
                for (File file: files) {
                    maxAndMin(file);
                }
        }
    }

    public void result() {
        System.out.printf("最大的文件是%s,其大小是%d字节", maxFile.getAbsolutePath(), maxLength);
        System.out.printf("最小的文件是%s,其大小是%d字节", minFile.getAbsolutePath(), minLength);
    }
}
