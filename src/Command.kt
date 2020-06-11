interface Command {
    fun execute(position: Position): Position
}

class Left : Command {
    override fun execute(position: Position) = position.turnLeft()
}

class Right : Command {
    override fun execute(position: Position): Position = position.turnRight()
}

class Move : Command {
    override fun execute(position: Position): Position = position.move()
}

fun newCommandFactory(code: Char): Command =
    when (code) {
        'L' -> Left()
        'R' -> Right()
        'M' -> Move()
        else -> throw IllegalArgumentException()
    }