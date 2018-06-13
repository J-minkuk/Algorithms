package converter;

public class MakeCamel {

  static String makeCamelFirstLowerCase(String str) {
    String[] sArr = str.toLowerCase().split(" ");
    StringBuilder sb = new StringBuilder();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < sArr.length; ++i) {
      sb.append(sArr[i]);
    }

    for (int i = 0; i < sb.length(); ++i) {
      char c = sb.charAt(i);
      if (i % 2 == 1) {
        result.append(Character.toString(c).toUpperCase());
      }
      else {
        result.append(c);
      }
    }
    return result.toString();
  }

  static String makeCamelFisrtUpperCase(String str) {
    String[] sArr = str.toLowerCase().split(" ");
    StringBuilder sb = new StringBuilder();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < sArr.length; ++i) {
      sb.append(sArr[i]);
    }

    for (int i = 0; i < sb.length(); ++i) {
      char c = sb.charAt(i);
      if (i % 2 == 0) {
        result.append(Character.toString(c).toUpperCase());
      }
      else {
        result.append(c);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String str = "Naver Campus Hackday";
    System.out.println(makeCamelFirstLowerCase(str));
    System.out.println(makeCamelFisrtUpperCase(str));
  }

}
