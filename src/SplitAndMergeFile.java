import java.io.*;
import java.util.Arrays;

public class SplitAndMergeFile {
    public static void split (File srcfile, int splitsize) {
        if (0 == srcfile.length()) {
            System.out.println("file length is zero, cannot split");
            return;
        }
        byte[] fileContent = new byte[(int) srcfile.length()];
        try {
            FileInputStream fis = new FileInputStream(srcfile);
            fis.read(fileContent);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int filenum;
        if (0 == fileContent.length % splitsize)
            filenum = fileContent.length / splitsize;
        else
            filenum = (int) fileContent.length / splitsize + 1;

        for (int i = 0; i < filenum; i++) {
            String filename = i + "-" + srcfile.getName();
            File newfile = new File(srcfile.getParent(), filename);

            byte[] newfileContent;

            if (i != filenum - 1) {
                newfileContent = Arrays.copyOfRange(fileContent, splitsize * i, splitsize * (i + 1));
            } else
                newfileContent = Arrays.copyOfRange(fileContent, splitsize * i, fileContent.length);

            try {
                FileOutputStream fos = new FileOutputStream(newfile);
                fos.write(newfileContent);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void merge (String folder, String filename) {
        File mergeFile = new File(folder, "new" + filename);
        try {
            FileOutputStream fos = new FileOutputStream(mergeFile);
            int index = 0;
            while (true){
                String subFileName = index + "-" + filename;
                index++;
                File subFile = new File(folder, subFileName);
                if (!subFile.exists()) {
                    return;
                }
                FileInputStream fis = new FileInputStream(subFile);
                byte[] subFileContent = new byte[(int) subFile.length()];
                fis.read(subFileContent);
                fis.close();
                fos.write(subFileContent);
                fos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
