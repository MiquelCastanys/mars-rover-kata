data class Position(private val coordinate: Coordinate, private val compass: Compass) {

    override fun toString(): String = "$coordinate $compass"

    fun turnLeft() = copy(compass = compass.turnLeft())
    fun turnRight() = copy(compass = compass.turnRight())
    fun move() = copy(coordinate = compass.move(coordinate))

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