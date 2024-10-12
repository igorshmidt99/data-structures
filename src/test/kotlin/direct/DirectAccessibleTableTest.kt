package direct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DirectAccessibleTableTest {

    private lateinit var table: DirectAccess<Any>

    @BeforeEach
    fun initTable() {
        table = DirectAccess(10)
    }

    @Test
    fun findMaxUpperBound() {
        table.insert(DirectAccess.Slot(2, "Some val"))
        table.insert(DirectAccess.Slot(5, "Some val"))
        table.insert(DirectAccess.Slot(7, "Some val"))

        val actual = getKey()

        assertEquals(7, actual)
    }

    @Test
    fun findMaxLowerBound() {
        table.insert(DirectAccess.Slot(0, "Some val"))

        val key = getKey()

        assertEquals(key, 0)
    }

    private fun getKey(): Int? {
        val result = table.findMax()
        return result?.key
    }
}