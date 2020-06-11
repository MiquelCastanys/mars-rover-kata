import Command.*

data class Position(val coordinate: Coordinate, val compass: Compass) {

    private fun move() = copy(coordinate = compass.move(coordinate))

    override fun toString(): String = "$coordinate $compass"

    fun evaluateMove(command: Command): Position = when (command) {
        RIGHT -> copy(compass = compass.turnRight())
        LEFT -> copy(compass = compass.turnLeft())
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