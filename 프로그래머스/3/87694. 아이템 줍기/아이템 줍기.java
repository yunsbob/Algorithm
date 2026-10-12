import java.util.*;

class Solution {
    int[][] map = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public class XY {
        int x, y, w;
        
        public XY (int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        draw(rectangle);
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    public void draw(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            int lx = rectangle[i][0] * 2;
            int ly = rectangle[i][1] * 2;
            int rx = rectangle[i][2] * 2;
            int ry = rectangle[i][3] * 2;
            
            for (int x = lx; x <= rx; x++) {
                for (int y = ly; y <= ry; y++) {
                    if (x == lx || x == rx || y == ly || y == ry) {
                        if (map[x][y] == 0) {
                            map[x][y] = 1;
                        }
                    } else {
                        map[x][y] = 2;
                    }
                }
            }
        }
    }
    
    public int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<XY> q = new LinkedList<>();
        
        q.add(new XY(characterX, characterY, 0));
        visited[characterX][characterY] = true;
        
        while(!q.isEmpty()) {
            XY now = q.poll();
            
            if (now.x == itemX && now.y == itemY) {
                return now.w / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dxy[i][0];
                int ny = now.y + dxy[i][1];
                
                if (nx < 1 || ny < 1 || nx > 100 || ny > 100 || visited[nx][ny] || map[nx][ny] != 1) continue;
                
                q.add(new XY(nx, ny, now.w + 1));
                visited[nx][ny] = true;
            }
        }
        
        return 0;
    }
}