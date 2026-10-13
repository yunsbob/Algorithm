import java.util.*;

class Solution {
    int w, h;
    int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[][] map;
    boolean[][] visited;
    
    public class XY {
        int x, y, cnt;
        
        public XY(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] maps) {
        int sx = 0;
        int sy = 0;
        w = maps[0].length();
        h = maps.length;
        map = new char[h][w];
        visited = new boolean[h][w];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = maps[i].charAt(j);
                
                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
            
        return bfs(sx, sy);
    }
    
    public int bfs(int sx, int sy) {
        boolean flag = false;
        Queue<XY> q = new LinkedList<>();
        
        q.add(new XY(sx, sy, 0));
        visited[sx][sy] = true;
        
        while(!q.isEmpty()) {
            XY now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dxy[i][0];
                int ny = now.y + dxy[i][1];
                
                if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }
                
                if (map[nx][ny] == 'E' && flag == true) {
                    return now.cnt + 1;
                } 
                
                if (map[nx][ny] == 'L' && flag == false) {
                    flag = true;
                    q.clear();
                    visited = new boolean[h][w];
                    visited[nx][ny] = true;
                    q.add(new XY(nx, ny, now.cnt + 1));
                    
                    break;
                }
                
                visited[nx][ny] = true;
                q.add(new XY(nx, ny, now.cnt + 1));
            }
        }
        
        return -1;
    }
}