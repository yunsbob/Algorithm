#include <iostream>
#include <queue>
using namespace std;

int N, M;
int map[1000][1000];
int res[1000][1000];
int dr[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
queue<pair<int, int>> q;

void bfs() {
    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();
        for (int i = 0; i < 4; ++i) {
            int nx = now.first + dr[i][0];
            int ny = now.second + dr[i][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || res[nx][ny] != 0) continue;
            res[nx][ny] = res[now.first][now.second] + 1;
            q.push({nx, ny});
        }
    }
}

int main(void) {
    cin >> N >> M;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> map[i][j];
            if (map[i][j] == 2) {
                q.push({i, j});
                map[i][j] = 0;
            }
        }
    }

    bfs();

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            if (map[i][j] == 1 && res[i][j] == 0)
                cout << -1 << ' ';
            else
                cout << res[i][j] << ' ';
        }
        cout << '\n';
    }
}