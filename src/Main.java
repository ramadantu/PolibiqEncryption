import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] arr = {
                {"a", "b", "c", "d", "e"},
                {"f", "g", "h", "(i/j)", "k"},
                {"l", "m", "n", "o", "p"},
                {"q", "r", "s", "t", "u"},
                {"v", "w", "x", "y", "z"},
        };

        System.out.print("Enter P: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputPlain = reader.readLine();
        char[] msg  = inputPlain.toLowerCase().toCharArray();

        StringBuilder encMsg = new StringBuilder();
        for (char c : msg) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j].contains(String.valueOf(c))) {
                        encMsg.append(i + 1).append(j + 1);
                    }
                }
            }
        }
        System.out.println("Encryption...");
        System.out.println("C = " + encMsg);

        System.out.print("Enter C: ");
        String inputEncr = reader.readLine();
        StringBuilder decMsg = new StringBuilder();
        char[] enc = inputEncr.toLowerCase().toCharArray();
        for (int i = 0; i < enc.length; i = i + 2) {
            decMsg.append(
                    arr[Integer.parseInt(String.valueOf(enc[i])) - 1][Integer.parseInt(String.valueOf(enc[i + 1])) - 1]
            );
        }
        System.out.println("Decryption...");
        System.out.print("P = " + decMsg);
    }
}