package direct

class BitSet(
    private var wordLength: Int,
    var set: BooleanArray
) {

    // TODO тесты + закончить упражнения

    fun or(another: BitSet) {
        verifyWordLength(another)
        for (i in set.indices) {
            if (another.set[i]) {
                set[i] = true
            }
        }
    }

    fun and(another: BitSet) {
        verifyWordLength(another)
        for (i in set.indices) {
            if (!another.set[i]) {
                set[i] = false
            }
        }
    }

    fun xor(another: BitSet) {
        verifyWordLength(another)
        for (i in set.indices) {
            if (set[i] && another.set[i]) {
                set[i] = false
                continue
            }
            if (another.set[i]) {
                set[i] = true
            }
        }
    }

    fun not() {
        for (i in set.indices) {
            if (!set[i]) {
                set[i] = true
                continue
            }
            if (set[i]) {
                set[i] = false
                continue
            }
        }
    }

    private fun verifyWordLength(set: BitSet) {
        require(wordLength == set.wordLength) {
            "Argument's word length is unequal to target"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BitSet

        if (wordLength != other.wordLength) return false
        if (!set.contentEquals(other.set)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = wordLength
        result = 31 * result + set.contentHashCode()
        return result
    }


}