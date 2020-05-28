import Rover.Command.LEFT
import Rover.Command.MOVE
import Rover.Command.RIGHT
import java.lang.Exception
import java.lang.IllegalArgumentException

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


    enum class Command(val code: Char) {
        LEFT('L'), RIGHT('R'), MOVE('M');
        companion object {
            fun from(code: Char) : Command =
                when(code) {
                    LEFT.code -> LEFT
                    RIGHT.code -> RIGHT
                    MOVE.code -> MOVE
                    else -> throw IllegalArgumentException()
                }
        }
    }
}
