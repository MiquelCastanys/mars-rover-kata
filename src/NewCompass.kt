import Compass.*
import Compass.Orientation.*

interface NewCompass {
    fun turnRight(): NewCompass
    fun turnLeft(): NewCompass
}

class North : NewCompass {
    override fun turnRight(): NewCompass = East()

    override fun turnLeft(): NewCompass = West()
}

class South : NewCompass {
    override fun turnRight(): NewCompass = West()

    override fun turnLeft(): NewCompass = East()
}

class East : NewCompass {
    override fun turnRight(): NewCompass = South()

    override fun turnLeft(): NewCompass = North()
}

class West : NewCompass {
    override fun turnRight(): NewCompass = North()

    override fun turnLeft(): NewCompass = South()
}

fun newCompassFactory(orientation: Orientation) =
    when (orientation) {
        NORTH -> North()
        EAST -> East()
        SOUTH -> South()
        WEST -> West()
    }