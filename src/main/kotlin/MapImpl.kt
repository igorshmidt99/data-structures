class MapImpl<K, V> {

    var size: Int = 0
    var values: Array<Any> = emptyArray()

    fun put(key: K, value: V) {

    }

    class Entry<K, V>(private var key: K, private var value: V)
}