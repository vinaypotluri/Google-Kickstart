import java.util.*;
import java.io.*;


public class Lshaped {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


    for (int i = 0; i < T; i++) {

        int R = in.nextInt();
        int C = in.nextInt();

        int[][] arr = new int[R][C];

        for(int r=0; r<R; r++)
        {
            for(int c=0; c<C; c++)
            {
                arr[r][c] = in.nextInt();
            }
        }

        int count = 0;

        outer: for(int a=0; a<arr.length; a++)
        {
            inner: for(int b=0; b<arr[0].length; b++)
            {
                if(arr[a][b] == 1)
                {
                    count += findL(arr, a, b);
                    //break outer;
                }

            }
        }


        System.out.println("Case #"+(i+1)+": "+count);

    }
  }

  public static int findL(int[][] arr, int i, int j)
  {
      int count = 0;

      int D = down(arr, i, j);
      int U = up(arr, i, j);
      int L = left(arr, i, j);
      int R = right(arr, i, j);

      // LU
      count += checkL(L, U);

      // LD
      count += checkL(L, D);

      // RU
      count += checkL(R, U);
     // System.out.println("RU: "+checkL(R,U));

      // RD
      count += checkL(R, D);

     return count;

  }

  public static int checkL(int a, int b)
  {
      //System.out.println("a: "+a+"\tb: "+b);

      // b = (2*a) + 1 || a = (2*b) + 1
      int count = 0;

      if(a<2 || b<2)    return 0;

      for(int i=2; i<=a; i++)
      {
        if( b >= (2*i))     count++;
      }

      for(int i=2; i<=b; i++)
      {
        if( a >= (2*i))     count++;
      }

      return count;
  }

  public static int down(int[][] arr, int i, int j)
  {
      if(i<0 || i>arr.length || j<0 || j>arr[i].length)
        return 0;

      int count = 0;

      for(int a=i; a<arr.length; a++)
      {
          if(arr[a][j] == 0)
            break;
          count++;
      }

      return count;
  }

  public static int up(int[][] arr, int i, int j)
  {
      if(i<0 || i>arr.length || j<0 || j>arr[i].length)
        return 0;

      int count = 0;

      for(int a=i; a>=0; a--)
      {
          if(arr[a][j] == 0)
            break;
          count++;
      }

      return count;
  }

  public static int left(int[][] arr, int i, int j)
  {
      if(i<0 || i>arr.length || j<0 || j>arr[i].length)
        return 0;

      int count = 0;

      for(int a=j; a>=0; a--)
      {
          if(arr[i][a] == 0)
            break;
          count++;
      }

      return count;
  }

  public static int right(int[][] arr, int i, int j)
  {
      if(i<0 || i>arr.length || j<0 || j>arr[i].length)
        return 0;

      int count = 0;

      for(int a=j; a<arr[i].length; a++)
      {
          if(arr[i][a] == 0)
            break;
          count++;
      }

      return count;
  }


}
