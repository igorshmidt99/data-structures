package direct

import org.junit.jupiter.api.Test

class DirectAccessTest {

    @Test
    fun test() {
        val fromZeroToTen = DirectAccess<BitSet>(10)

        Slot(0, BitSet(4, arrayOf(0, 0, 0, 1)))
        Slot(1, BitSet(4, arrayOf(0, 0, 1, 0)))
        Slot(2, BitSet(4, arrayOf(0, 0, 1, 1)))
        Slot(3, BitSet(4, arrayOf(0, 1, 0, 0)))
        Slot(4, BitSet(4, arrayOf(0, 1, 0, 1)))
        Slot(5, BitSet(4, arrayOf(0, 1, 1, 0)))
        Slot(6, BitSet(4, arrayOf(0, 1, 1, 1)))
        Slot(7, BitSet(4, arrayOf(1, 0, 0, 0)))
        Slot(8, BitSet(4, arrayOf(1, 0, 0, 1)))
        Slot(9, BitSet(4, arrayOf(1, 0, 1, 0)))


    }

}
