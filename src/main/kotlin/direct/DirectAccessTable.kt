package direct

class DirectAccessTable<V>(keys: Int) {

    class Slot<V>(val key: Int, val value: V)

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

}