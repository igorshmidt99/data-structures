package direct

class DirectAccess<V>(keys: Int) {

    private val table: Array<Slot<V>?> = arrayOfNulls(keys)

    fun search(key: Int): Slot<V>? {
        return table[key]
    }

    fun insert(slot: Slot<V>) {
        table[slot.key] = slot
    }

    fun delete(slot: Slot<V>) {
        table[slot.key] = null
    }

    fun findMax(): Slot<V>? {
        for (i in table.size - 1 downTo 0) {
            if (table[i] != null) {
                return table[i]
            }
        }
        return null
    }

}

class Slot<V>(val key: Int, val value: V)