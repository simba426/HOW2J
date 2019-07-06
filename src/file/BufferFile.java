package file;

import java.io.*;

public class BufferFile {
    public static void removeComments(File javaFile) {
        StringBuffer sb = new StringBuffer();
        try (FileReader fr = new FileReader(javaFile);
             BufferedReader br = new BufferedReader(fr)){
            while(true) {
                String line = br.readLine();
                if (null == line)
                    break;
                if (!line.trim().startsWith("//"))
                    sb.append(line).append("\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(javaFile);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
