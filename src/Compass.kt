import Compass.Orientation.*

class Compass(var orientation: Orientation = NORTH) {

    fun turnLeft(): Orientation = when (orientation) {
        NORTH -> WEST
        WEST -> SOUTH
        SOUTH -> EAST
        EAST -> NORTH
    }

    fun turnRight(): Orientation =
        when (orientation) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
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