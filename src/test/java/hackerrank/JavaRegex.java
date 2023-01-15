package hackerrank;

import java.util.Scanner;


public class JavaRegex {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            var ip = scanner.nextLine();
            System.out.println(validateIp(ip));
        }
    }

    private static boolean validateIp(String ip) {
        return ip.matches(MyRegex.PATTERN);
    }

    static class MyRegex {
        public static final String PATTERN = "^(([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)\\.){3}([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)$";
    }
}
