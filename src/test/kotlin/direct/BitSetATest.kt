package direct

import BitSetA
import ParameterizedExtension
import Value
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals

class BitSetATest {

    private lateinit var bitSet: BitSet

    @ExtendWith(ParameterizedExtension::class)
    @TestTemplate
    @Value(
        value = [
            BitSetA(wordLength = 4, bits = booleanArrayOf(false, false, false, true)),
            BitSetA(wordLength = 4, bits = booleanArrayOf(false, false, true, false)),
            BitSetA(wordLength = 4, bits = booleanArrayOf(true, true, true, true))
        ]
    )
    fun orWithEmptyMainSet(another: BitSet) {
        bitSet = BitSet(4, booleanArrayOf(false, false, false, false))

        bitSet.or(another)

        assertEquals(bitSet, another)
    }

    @ExtendWith(ParameterizedExtension::class)
    @TestTemplate
    @Value(
        value = [
            BitSetA(wordLength = 4, bits = booleanArrayOf(false, false, false, true)),
            BitSetA(wordLength = 4, bits = booleanArrayOf(false, false, true, false)),
            BitSetA(wordLength = 4, bits = booleanArrayOf(true, true, true, true))
        ]
    )
    fun orWith() {
        bitSet = BitSet(4, booleanArrayOf(false, true, false, true))
    }

}