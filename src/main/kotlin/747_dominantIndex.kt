fun dominantIndex(nums: IntArray): Int {
    var max = 0
    for (i in 1 until nums.size) {
        if (max < nums[i]) {
            max = i
        }
    }

    for (i in nums.indices) {
        if (i != max) {
            if (max < nums[i] * 2) {
                return -1
            }
        }
    }
    return max
}


fun main() {
    dominantIndex(intArrayOf(0, 2, 0, 2))
}