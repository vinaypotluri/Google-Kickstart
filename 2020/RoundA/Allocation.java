import java.util.*;
import java.io.*;


public class Allocation {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


    for (int i = 0; i < t; i++) {

      int N = in.nextInt();
      int B = in.nextInt();

      int[] houses = new int[N];

      for(int j=0; j<N; j++)
      {
          int val = in.nextInt();
          houses[j] = val;
      }


      total(houses, B, i);
    }
  }

  public static void total(int[] houses, int bal, int pos)
  {
      Arrays.sort(houses);
      int count = 0;

      for(int house : houses)
      {
            if((bal - house) < 0)
                break;

            bal = bal - house;
            count++;
      }

      System.out.println("Case #"+(pos+1)+": "+count);
  }
}
