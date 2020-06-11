import Command.*

data class Position(var x: Int, var y: Int, val newCompass: NewCompass) {

    private fun move() =
        when (newCompass) {
            is North -> copy(y = y + 1)
            is East -> copy(x = x + 1)
            is South -> copy(y = y - 1)
            is West -> copy(x = x - 1)
            else -> this
        }

    override fun toString(): String = "$x $y $newCompass"

    fun evaluateMove(command: Command): Position = when (command) {
        RIGHT -> copy(newCompass = newCompass.turnRight())
        LEFT -> copy(newCompass = newCompass.turnLeft())
        MOVE -> move()
    }

    enum class Orientation(val code: String) {
        NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

        companion object {
            fun from(orientation: String) =
                when (orientation) {
                    "N" -> NORTH
                    "S" -> SOUTH
                    "E" -> EAST
                    "W" -> WEST
                    else -> NORTH
                }
        }
    }
}