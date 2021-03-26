import java.util.*;
import java.io.*;


public class Goodness {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


    for (int i = 1; i <= T; i++) {

        int N = in.nextInt();
        int K = in.nextInt();

        String str = in.next();

        int good = goodness(str);

        System.out.println("Case #"+i+": "+(Math.abs(good-K)));

    }
  }

  public static int goodness(String str)
  {
      int i = 0;
      int j = str.length()-1;
      int count = 0;

      while(i<j)
      {
          if(str.charAt(i) != str.charAt(j))
            count++;

        i++;
        j--;
      }

      return count;
  }


}
