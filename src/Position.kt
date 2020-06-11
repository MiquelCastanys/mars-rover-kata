data class Position(private val coordinate: Coordinate, private val compass: Compass) {

    override fun toString(): String = "$coordinate $compass"

    fun turnLeft() = copy(compass = compass.turnLeft())
    fun turnRight() = copy(compass = compass.turnRight())
    fun move() = copy(coordinate = compass.move(coordinate))
}