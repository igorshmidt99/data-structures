package direct

class BitSet(
    private var word: Int,
    var set: Array<Int?> = arrayOfNulls(word)
) {

    fun or(another: BitSet) {
        for (i in set.indices) {
            if (another.set[i] == 1) {
                set[i] = 1
            }
        }
    }

    fun and(another: BitSet) {
        for (i in set.indices) {
            if (another.set[i] == 0) {
                set[i] = 0
            }
        }
    }

    fun xor(another: BitSet) {
        for (i in set.indices) {
            if (set[i] == 1 && another.set[i] == 1) {
                set[i] = 0
                continue
            }
            if (another.set[i] == 1) {
                set[i] = 1
                continue
            }
        }
    }

    fun not() {
        for (i in set.indices) {
            if (set[i] == 0) {
                set[i] = 1
                continue
            }
            if (set[i] == 1) {
                set[i] = 0
                continue
            }
        }
    }

}