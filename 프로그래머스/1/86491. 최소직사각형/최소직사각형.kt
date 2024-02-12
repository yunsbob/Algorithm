class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var width = 0
        var length = 0
        
        for (size in sizes) {
            if (size[0] > size[1]) {
                length = if (size[0] > length) size[0] else length
                width = if (size[1] > width) size[1] else width
            } else {
                length = if (size[1] > length) size[1] else length
                width = if (size[0] > width) size[0] else width
            }
        }
        
        return width * length
    }
}