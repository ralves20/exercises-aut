
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class GenerateANewString {

    private String removeLastChar(String str) {
        System.out.println(str.substring(0, str.length() - 1));
        return (str.substring(0, str.length() - 1));
    }

    private String removeDuplicate(String stringToRemove) {

        char[] chars = stringToRemove.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        System.out.println(stringToRemove);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private String
    generateDuplicatedString(String str) {
        String newString = "";
        StringBuilder generatedNewString = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map.put(c, 1);
        }

        for (char c : map.keySet()) {
            generatedNewString.append(c).append(c);
        }
        System.out.println(generatedNewString.toString());
        return generatedNewString.toString();
    }


    public static String reverseString(String str) {
        char[] in = str.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        System.out.println(in);
        return new String(in);
    }


    private String generateTheExpectedString(String str) {
        String stringGenerated = generateDuplicatedString(str);
        String stringGenerated2 = reverseString(stringGenerated);
        return removeLastChar("FINAL STRING GENERATED: " + stringGenerated2);
    }

    @Test
    public void abcdTest() {
        generateTheExpectedString("CODE");
    }
}
