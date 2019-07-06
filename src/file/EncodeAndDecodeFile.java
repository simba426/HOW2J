package file;

import java.io.*;

public class EncodeAndDecodeFile {
    public static void encodeFile (File encodingFile, File encodedFile) {
        try(FileReader fr = new FileReader(encodingFile);
            FileWriter fw = new FileWriter(encodedFile)) {
            char[] fileContent = new char[(int) encodingFile.length()];
            fr.read(fileContent);
            for (int i = 0; i < fileContent.length; i++) {
                if (fileContent[i] >= '0' && fileContent[i] <= '9') {
                    if (fileContent[i] == '9')
                        fileContent[i] = '0';
                    else
                        fileContent[i] += 1;
                }
                else if (fileContent[i] >= 'A' && fileContent[i] <= 'Z') {
                    if (fileContent[i] == 'Z')
                        fileContent[i] = 'A';
                    else
                        fileContent[i] += 1;
                }
                else if (fileContent[i] >= 'a' && fileContent[i] <= 'z') {
                    if (fileContent[i] == 'z')
                        fileContent[i] = 'a';
                    else
                        fileContent[i] += 1;
                }
                else
                    continue;
            }
            fw.write(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decodeFile (File decodingFile, File decodedFile) {
        try(FileReader fr = new FileReader(decodingFile);
            FileWriter fw = new FileWriter(decodedFile)) {
            char[] fileContent = new char[(int) decodingFile.length()];
            fr.read(fileContent);
            for (int i = 0; i < fileContent.length; i++) {
                if (fileContent[i] >= '0' && fileContent[i] <= '9') {
                    if (fileContent[i] == '0')
                        fileContent[i] = '9';
                    else
                        fileContent[i] -= 1;
                }
                else if (fileContent[i] >= 'A' && fileContent[i] <= 'Z') {
                    if (fileContent[i] == 'A')
                        fileContent[i] = 'Z';
                    else
                        fileContent[i] -= 1;
                }
                else if (fileContent[i] >= 'a' && fileContent[i] <= 'z') {
                    if (fileContent[i] == 'a')
                        fileContent[i] = 'z';
                    else
                        fileContent[i] -= 1;
                }
                else
                    continue;
            }
            fw.write(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
