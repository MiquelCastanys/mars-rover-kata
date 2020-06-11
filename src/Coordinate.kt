data class Coordinate(private val x: Int, private val y: Int) {
    fun incrementX() = copy(x = x + 1)
    fun incrementY() = copy(y = y + 1)
    fun decrementX() = copy(x = x - 1)
    fun decrementY() = copy(y = y - 1)

    override fun toString(): String = "$x $y"
}