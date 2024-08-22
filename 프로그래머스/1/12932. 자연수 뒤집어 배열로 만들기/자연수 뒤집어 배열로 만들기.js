function solution(n) {
    const res = [];
    while (n > 0) {
        res.push(n % 10);
        n = Math.floor(n / 10);
    }
    
    return res;
}