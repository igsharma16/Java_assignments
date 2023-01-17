package utilities;
public class ProvidePadding {
    public static String paddLeft(String str, int length, char ch ) {
        if (str.length()>=length) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
    
        while (sb.length() < length-str.length()) {
            sb.append(ch);
        }
        return sb.toString() + str;
    }

    public static String paddRight(String str, int length, char ch) {
        if (str.length()>=length) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
    
        while (sb.length() < length-str.length()) {
            sb.append(ch);
        }
        return str + sb.toString();
    }

    public static String paddBoth(String str, int length, char ch) {
        if (str.length() >= length) {
            return str;
        }
        StringBuilder sb  = new StringBuilder();

        int diff = length - str.length();
        while (sb.length() < diff/2) {
            sb.append(ch);
        }
        sb.append(str);
        while (sb.length()-str.length() < diff) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
