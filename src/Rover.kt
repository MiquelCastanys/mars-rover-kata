import Compass.Orientation.EAST
import Compass.Orientation.NORTH
import Compass.Orientation.SOUTH
import Compass.Orientation.WEST
import Rover.Direction.LEFT
import Rover.Direction.MOVE
import Rover.Direction.RIGHT

/*5 5
1 2 N
LMLMLMLMM
1 3 N*/

class Rover {
    fun computeMoves(input: String): String {
        //Single Responsability
        //parsing
        val inputValues = input.split("\n")
        val currentPosition = inputValues[1]
        //computing
        if (hasMoveCommand(inputValues)) return currentPosition
        return executeCommand(inputValues, currentPosition)
    }

    //Primitive obsession
    private fun executeCommand(inputValues: List<String>, currentPosition: String): String {
        //Single Responsability extract logic to Position
        val compass = Compass()
        //parsing
        val moveCommand = inputValues[2] //extract to a class to manage commands
        //executing
        moveCommand.forEach {
            //Switch Statement into Position class
            if (it == RIGHT.code) return compass.turnRight(currentPosition)
            if (it == LEFT.code) return compass.turnLeft(currentPosition)
            if (it == MOVE.code) return move(parsePosition(currentPosition))
        }
        return ""
    }

    //primitive obsession
    private fun move(position: Position): String { //Extract current position as a class
        //Single responsabilities
        //Parsing input
        //x and y Data Cluster
        //Evaluate direction
        //Switch Statement
        return when (position.compass.orientation) {
            //Move extract logic into Position class
            NORTH -> "${position.x} ${position.y + 1} ${position.compass.orientation.code}" //Extract string creation in a toString method
            EAST -> "${position.x - 1} ${position.y} ${position.compass.orientation.code}"
            SOUTH -> "${position.x} ${position.y - 1} ${position.compass.orientation.code}"
            WEST -> "${position.x - 1} ${position.y} ${position.compass.orientation.code}"
        }
    }



    private fun hasMoveCommand(inputValues: List<String>) = inputValues.size == 2

    enum class Direction(val code: Char) {
        LEFT('L'), RIGHT('R'), MOVE('M')
    }
}
