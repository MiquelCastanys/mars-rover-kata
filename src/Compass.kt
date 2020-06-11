import java.lang.IllegalArgumentException

interface Compass {
    fun turnRight(): Compass
    fun turnLeft(): Compass
    fun move(coordinate: Coordinate): Coordinate
}

class North : Compass {
    override fun turnRight(): Compass = East()
    override fun turnLeft(): Compass = West()
    override fun move(coordinate: Coordinate): Coordinate = coordinate.incrementY()
    override fun toString(): String = "N"
}

class South : Compass {
    override fun turnRight(): Compass = West()
    override fun turnLeft(): Compass = East()
    override fun move(coordinate: Coordinate): Coordinate = coordinate.decrementY()
    override fun toString(): String = "S"
}

class East : Compass {
    override fun turnRight(): Compass = South()
    override fun turnLeft(): Compass = North()
    override fun move(coordinate: Coordinate): Coordinate = coordinate.incrementX()
    override fun toString(): String = "E"
}

class West : Compass {
    override fun turnRight(): Compass = North()
    override fun turnLeft(): Compass = South()
    override fun move(coordinate: Coordinate): Coordinate = coordinate.decrementX()
    override fun toString(): String = "W"
}

fun compassFactory(orientationCode: String) =
    when (orientationCode) {
        "N" -> North()
        "E" -> East()
        "S" -> South()
        "W" -> West()
        else -> throw IllegalArgumentException()
    }