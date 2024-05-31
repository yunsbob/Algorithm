function solution(s){
    return s.split("p").length + s.split("P").length === s.split("y").length + s.split("Y").length;
}