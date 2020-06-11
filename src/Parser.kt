fun parsePosition(currentPosition: String): Position {
    val currentPositionInfo = currentPosition.split(" ") //Extract parsing to a method in another class
    val x = currentPositionInfo[0].toInt()
    val y = currentPositionInfo[1].toInt()
    val currentOrientation = currentPositionInfo[2]
    return Position(
        x,
        y,
        Compass(Compass.Orientation.from(currentOrientation)),
        newCompassFactory(Compass.Orientation.from(currentOrientation))
    )
}

fun parseInput(input: String): Pair<List<Command>, Position> {
    val inputValues = input.split("\n")
    val currentPosition = parsePosition(inputValues[1])
    val moveCommand = parseCommands(inputValues) //extract to a class to manage commands
    return Pair(moveCommand, currentPosition)
}

private fun hasMoveCommand(inputValues: List<String>) = inputValues.size > 2

private fun parseCommands(inputValues: List<String>) =
    if (hasMoveCommand(inputValues))
        inputValues[2].map { Command.from(it) }
    else listOf()