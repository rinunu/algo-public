// コピペして使うよ

private fun IntArray.indexOf(start: Int, v: Int): Int {
    for (i in start until this.size) {
        if (this[i] == v) {
            return i
        }
    }
    return -1
}

private fun readIntArray(): IntArray {
    return readLine()!!.split(" ").map { it.toInt() }
        .toIntArray()
}

/**
 * https://www.codegrepper.com/code-examples/java/next_permutation+java
 */
private fun nextPermutation(arr: IntArray): Boolean {
    var len = arr.size
    var i = len - 1

    // 1. find largest i where arr[i - 1] < arr[i]
    while (i > 0) {
        if (arr[i - 1] < arr[i]) break
        i--
    }
    if (i <= 0) return false

    // 2. find largest j where arr[i - 1] < arr[j] and j >= i
    var j = len - 1
    while (j >= i) {
        if (arr[i - 1] < arr[j]) break
        j--
    }

    // 3. swap elements between arr[i-1] and arr[j]
    swap(i - 1, j, arr)

    // 4. reverse elements from i to end of array
    len--
    while (i < len) {
        swap(i, len, arr)
        len--
        i++
    }
    return true
}

private fun swap(x: Int, y: Int, arr: IntArray) {
    val temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp
}
