package PG;

import java.util.*;

class PG_1844 {
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static int[][] dist;
    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    };

    public int solution(int[][] maps) {
        int h = maps.length;
        int w = maps[0].length;

        dist = new int[h][w];
        for(int row = 0; row < h; row++) {
            for(int col = 0; col < w; col++) {
                dist[row][col] = 0;
            }
        }

        return bfs(maps);
    }

    public static int bfs(int[][] board) {
        Queue<Point> q = new LinkedList<>();

        int row = board.length;
        int col = board[0].length;

        dist[0][0] = 1;
        q.offer(new Point(0, 0));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int curDist = dist[cur.y][cur.x];

            if(cur.y == row - 1 && cur.x == col - 1) {
                return dist[cur.y][cur.x];
            }

            for(int dir = 0; dir < 4; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];

                if(ny < 0 || ny >= row || nx < 0 || nx >= col) continue;
                if(board[ny][nx] == 0) continue;
                if(dist[ny][nx] != 0) continue;

                dist[ny][nx] = curDist + 1;
                q.offer(new Point(ny, nx));
            }
        }

        return -1;
    }
}