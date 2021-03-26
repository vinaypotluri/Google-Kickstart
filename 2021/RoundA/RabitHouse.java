import java.util.*;
import java.io.*;

class Node {
    int val;
    int i;
    int j;

    Node(int val, int i, int j)
    {
        this.val = val;
        this.i = i;
        this.j = j;
    }
}

public class Solution {

  static int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int T = in.nextInt();

    for(int t=0; t<T; t++)
    {
        int R = in.nextInt();
        int C = in.nextInt();

        int[][] grid = new int[R][C];
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->(Integer.compare(b.val, a.val)));

        for(int r=0; r<R; r++)
        {
            for(int c=0; c<C; c++)
            {
                grid[r][c] = in.nextInt();
                pq.add(new Node(grid[r][c], r, c));
            }
        }

        getCount(grid, pq, t+1);

    }

    }

    public static void getCount(int[][] grid, PriorityQueue<Node> pq, int num)
    {
        long count = 0;

        while(!pq.isEmpty())
        {
            Node temp = pq.poll();
            int i = temp.i;
            int j = temp.j;
            int val = temp.val;

            if(grid[i][j] != val)   continue;

            for(int[] dir : directions)
            {
                int x = dir[0] + i;
                int y = dir[1] + j;

                if(x<0 || y<0 || x>grid.length-1 || y>grid[0].length-1) continue;

                int v = grid[x][y];

                if(v >= val || v == val-1) continue;
                if(v < val)
                {
                    count += val - v - 1;
                    grid[x][y] = val - 1;
                    pq.add(new Node(grid[x][y], x, y));
                }
            }

        }

        System.out.println("Case #"+num+": "+count);
    }

}
