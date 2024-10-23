package extension

import BitSetA
import ParameterizedExtension
import Value
import direct.BitSet
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertNotEquals

class ParameterizedExtensionTest {

    private lateinit var bitSet: BitSet
    private var previous: BitSet? = null

    @BeforeEach
    fun init() {
        bitSet = BitSet(4, booleanArrayOf(false, false, false, false))
    }

    @ExtendWith(ParameterizedExtension::class)
    @Value(
        value = [
            BitSetA(wordLength = 4, bits = booleanArrayOf(false, false, false, false)),
            BitSetA(wordLength = 4, bits = booleanArrayOf(false, false, true, false)),
            BitSetA(wordLength = 4, bits = booleanArrayOf(false, true, false, false))
        ]
    )
    @TestTemplate
    fun checkAnnotationsBehaviour(another: BitSet?) {
        assertNotEquals(previous, another)
        previous = another
    }

}