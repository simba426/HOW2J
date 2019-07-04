import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class SearchFileThread extends Thread {
    private File file;
    private String search;

    public SearchFileThread(File file, String search) {
        this.file = file;
        this.search = search;
    }

    public void run () {
        String fileContent = getFileContent(file);
        if (fileContent.contains(fileContent))
            System.out.printf("找到目标字符串%s在%s中", search, file.getName());
    }

    public String getFileContent(File file) {
        try (FileReader fr = new FileReader(file);){
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
