import Command.*
import Compass.Orientation.EAST
import Compass.Orientation.NORTH
import Compass.Orientation.SOUTH
import Compass.Orientation.WEST

data class Position(var x: Int, var y: Int, val compass: Compass, val newCompass: NewCompass) {

    fun move() =
        when (compass.orientation) {
            NORTH -> copy(y = y + 1)
            EAST -> copy(x = x + 1)
            SOUTH -> copy(y = y - 1)
            WEST -> copy(x = x - 1)
        }

    override fun toString(): String = "$x $y ${compass.orientation.code}"

    fun turnRight(): Position = copy(compass = Compass(compass.turnRight()))

    fun turnLeft(): Position = copy(compass = Compass(compass.turnLeft()))

    fun evaluateMove(command: Command): Position = when (command) {
        RIGHT -> turnRight()
        LEFT -> turnLeft()
        MOVE -> move()
    }
}