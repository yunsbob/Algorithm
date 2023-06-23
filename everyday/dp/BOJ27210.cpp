#include<iostream>
using namespace std;

int main() {
    int N, left = 0, right = 0, res = 0;
    cin >> N;

    for (int i = 0; i < N; ++i) {
        int num;
        cin >> num;
        if (num == 1) {
            ++left;
            --right;
            if (right == -1) right = 0;
        } else {
            ++right;
            --left;
            if (left == -1) left = 0;
        }
        res = max(res, max(left, right));
    }
    cout << res;
}