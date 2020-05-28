import Command.LEFT
import Command.MOVE
import Command.RIGHT

/*5 5
1 2 N
LMLMLMLMM
1 3 N*/

class Rover {
    fun computeMoves(input: String): String {
        val (inputValues, currentPosition) = parseInput(input)
        return executeCommand(inputValues, currentPosition)
    }

    private fun executeCommand(inputValues: List<Command>, currentPosition: Position): String {
        var nextPosition = currentPosition
        inputValues.forEach {
            nextPosition = when (it) {
                RIGHT -> nextPosition.turnRight()
                LEFT -> nextPosition.turnLeft()
                MOVE -> currentPosition.move()
            }
        }
        return nextPosition.toString()
    }

}

