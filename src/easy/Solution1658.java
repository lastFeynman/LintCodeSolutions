package easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution1658 {
    public boolean isLegalIdentifier(String str) {
        String regex = "^[a-zA-Z_][a-zA-Z0-9_]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches())
            return true;

        return false;
    }
}
