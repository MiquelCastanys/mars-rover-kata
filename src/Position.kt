import Command.*

data class Position(val coordinate: Coordinate, val newCompass: NewCompass) {

    private fun move() =
        when (newCompass) {
            is North -> copy(coordinate = coordinate.incrementY())
            is East -> copy(coordinate = coordinate.incrementX())
            is South -> copy(coordinate = coordinate.decrementY())
            is West -> copy(coordinate = coordinate.decrementX())
            else -> this
        }

    override fun toString(): String = "$coordinate $newCompass"

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