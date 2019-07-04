
import java.util.ArrayList;
import java.util.List;

public class HackPasswordThread extends Thread {
    private boolean isRight = false;
    private String password;
    private List<String> passwords = new ArrayList<>();

    public HackPasswordThread(String password, List<String> passwords) {
        this.password = password;
        this.passwords = passwords;
    }

    @Override
    public void run() {
        char[] guessPassword = new char[this.password.length()];
        generatePassword(guessPassword, this.password);
    }

    public void generatePassword(char[] guessPassword, String password) {
        generatePassword(guessPassword, 0, password);
    }

    public void generatePassword(char[] guessPassword, int index, String password) {
        if (isRight)
            return;
        for (short i = '0'; i <= 'z'; i++) {
            char c = (char) i;
            if (Character.isLetterOrDigit(c))
                guessPassword[index] = c;
            if (index < password.length() - 1) {
                generatePassword(guessPassword, index + 1, password);
            }
            else {
                String guess = new String(guessPassword);
                passwords.add(guess);
                if (guess.equals(password)) {
                    System.out.printf("找到密码了，是%s%n", guess);
                    this.isRight = true;
                    return;
                }
            }
        }
    }
}
