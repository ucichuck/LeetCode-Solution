package leetcode.Solutions;

import java.util.LinkedList;

public class SurroundedRegions {
	public void solve(char[][] board) {
        if (board==null || board.length<1)
            return;
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++)
            for (int j=0; j<board[i].length; j++)
                if (board[i][j]=='O' && !visit[i][j] && (i==0||j==0||i==board.length-1||j==board[i].length-1)) {
                	LinkedList<Point> queue = new LinkedList<Point>();
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        if (point.j>0 && board[point.i][point.j-1]=='O' && !visit[point.i][point.j-1]) {
                            queue.add(new Point(point.i, point.j-1));
                           visit[point.i][point.j-1] = true; //add code here
                        }
                        if (point.j<board[point.i].length-1 && board[point.i][point.j+1]=='O' && !visit[point.i][point.j+1]) {
                            queue.add(new Point(point.i, point.j+1));
                           visit[point.i][point.j+1] = true;//add code here
                        }
                        if (point.i>0 && board[point.i-1][point.j]=='O' && !visit[point.i-1][point.j]) {
                            queue.add(new Point(point.i-1, point.j));
                            visit[point.i-1][point.j] = true;//add code here
                        }
                        if (point.i<board.length-1 && board[point.i+1][point.j]=='O' && !visit[point.i+1][point.j]) {
                            queue.add(new Point(point.i+1, point.j));
                           visit[point.i+1][point.j] = true;//add code here
                        }
                    }
                }
        for (int i=0; i<board.length; i++)
            for (int j=0; j<board[i].length; j++)
                if (visit[i][j])
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
    }
    class Point {
        public int i;
        public int j;
        public Point(int ii, int jj) {
            this.i = ii;
            this.j = jj;
        }
    }
}
