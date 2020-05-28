fun parsePosition(currentPosition: String): Position {
    val currentPositionInfo = currentPosition.split(" ") //Extract parsing to a method in another class
    val x = currentPositionInfo[0].toInt()
    val y = currentPositionInfo[1].toInt()
    val currentOrientation = currentPositionInfo[2]
    return Position(x, y, Compass(Compass.Orientation.from(currentOrientation)))
}