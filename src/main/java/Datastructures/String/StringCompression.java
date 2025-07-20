package Datastructures.String;

public class StringCompression {
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println("Original String: " + str);
        System.out.println("Compressed String: " + compressString(str));
        System.out.println("Compressed String using single loop: " + compressionString(str));
    }

    // Function to compress a string
    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return str + "1"; // If the string has only one character, append '1'
        }
        // Iterate through the string and count consecutive characters
        for (int i = 0; i <= str.length() - 1; i++) {
            char str1 = str.charAt(i);
            int n=1;
            for (int j=i+1;j<str.length();j++){
                if (str.charAt(i)!=str.charAt(j)){
                    break;
                }
                n++;
            }
            i += n - 1; // Move the index to the last counted character
            sb.append(str1+""+n);
        }
        return sb.toString();
    }

    // using single loop

    public static String compressionString(String str) {
        if (str == null || str.length()==0) {
            return str;
        }
        if (str.length() == 1) {
            return str + "1"; // If the string has only one character, append '1'
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i=1;i<=str.length()-1;i++) {
            if (str.charAt(i)==str.charAt(i-1)){
                count ++;
            } else {
                sb.append(str.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(count);
        return sb.toString().length() < str.length() ? sb.toString() : str;
    }
}
