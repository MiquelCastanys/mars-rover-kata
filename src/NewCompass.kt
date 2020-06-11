import Position.Orientation.*

interface NewCompass {
    fun turnRight(): NewCompass
    fun turnLeft(): NewCompass
}

class North : NewCompass {
    override fun turnRight(): NewCompass = East()
    override fun turnLeft(): NewCompass = West()
    override fun toString(): String = "N"
}

class South : NewCompass {
    override fun turnRight(): NewCompass = West()
    override fun turnLeft(): NewCompass = East()
    override fun toString(): String = "S"
}

class East : NewCompass {
    override fun turnRight(): NewCompass = South()
    override fun turnLeft(): NewCompass = North()
    override fun toString(): String = "E"
}

class West : NewCompass {
    override fun turnRight(): NewCompass = North()
    override fun turnLeft(): NewCompass = South()
    override fun toString(): String = "W"
}

fun newCompassFactory(orientation: Position.Orientation) =
    when (orientation) {
        NORTH -> North()
        EAST -> East()
        SOUTH -> South()
        WEST -> West()
    }