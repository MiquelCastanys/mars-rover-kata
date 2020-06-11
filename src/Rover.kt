/*5 5
1 2 N
LMLMLMLMM
1 3 N*/

class Rover {
    fun computeMoves(input: String): String {
        val (inputValues, currentPosition) = parseInput(input)
        return CommandExecutor(inputValues).executeCommands(currentPosition)
    }
}

class CommandExecutor(private val inputValues: List<Command>) {
    fun executeCommands(currentPosition: Position): String {
        var nextPosition = currentPosition
        inputValues.forEach {
            nextPosition = it.execute(nextPosition)
        }
        return nextPosition.toString()
    }
}