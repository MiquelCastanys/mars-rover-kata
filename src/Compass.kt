import Compass.Orientation.*

class Compass(var orientation: Orientation = NORTH) {

    fun turnLeft(currentPosition: String): String {
        val currentOrientation = currentPosition.split(" ")[2]
        val direction = when (currentOrientation) {
            NORTH.code -> WEST.code
            WEST.code -> SOUTH.code
            SOUTH.code -> EAST.code
            EAST.code -> NORTH.code
            else -> currentOrientation
        }
        return currentPosition.replace(currentOrientation, direction)
    }

    fun turnRight(currentPosition: String): String {
        val currentOrientation = currentPosition.split(" ")[2]
        val direction = when (currentOrientation) {
            NORTH.code -> EAST.code
            EAST.code -> SOUTH.code
            SOUTH.code -> WEST.code
            WEST.code -> NORTH.code
            else -> currentOrientation
        }
        return currentPosition.replace(currentOrientation, direction)
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