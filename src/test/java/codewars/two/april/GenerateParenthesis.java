package codewars.two.april;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

  public static void main(String[] args) {
    List<String> strings = generateParenthesis(3);

    for (String string : strings) {
      System.out.println(string);
    }
  }

  static List<String> generateParenthesis(int n) {
    return printParenthesis(new ArrayList<>(), new char[6], 0, n, 0, 0);
  }

  static List<String> printParenthesis(
          List<String> list, char[] str, int pos, int n, int open, int close) {
    if (close == n) {
      // print the possible combinations
      StringBuilder sb = new StringBuilder();
      for (char c : str) sb.append(c);
      list.add(sb.toString());

    } else {
      if (open > close) {
        str[pos] = ')';
        printParenthesis(list, str, pos + 1, n, open, close + 1);
      }
      if (open < n) {
        str[pos] = '(';
        printParenthesis(list, str, pos + 1, n, open + 1, close);
      }
    }

    return list;
  }
}
