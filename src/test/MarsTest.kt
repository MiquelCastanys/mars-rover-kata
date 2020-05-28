package test
/*5 5
1 2 N
LMLMLMLMM
1 3 N*/
import Rover
import org.junit.Test
import kotlin.test.assertEquals

class MarsTest {

    @Test
    fun `should not move if input does not have move command`() {
        val notMovingInput = "5 5\n1 2 N"
        val notMovingOutput = "1 2 N"
        val rover = Rover()

        val output = rover.computeMoves(notMovingInput)

        assertEquals(notMovingOutput, output)
    }

    @Test
    fun `should move east when turning right from north`() {
        val inputMoveRight = "5 5\n1 2 N\nR"
        val outputMoveRight = "1 2 E"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveRight)

        assertEquals(outputMoveRight, output)
    }

    @Test
    fun `should move south when turning right from east`() {
        val inputMoveRight = "5 5\n1 2 E\nR"
        val outputMoveRight = "1 2 S"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveRight)

        assertEquals(outputMoveRight, output)
    }

    @Test
    fun `should move west when turning right from south`() {
        val inputMoveRight = "5 5\n1 2 S\nR"
        val outputMoveRight = "1 2 W"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveRight)

        assertEquals(outputMoveRight, output)
    }

    @Test
    fun `should move north when turning right from west`() {
        val inputMoveRight = "5 5\n1 2 W\nR"
        val outputMoveRight = "1 2 N"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveRight)

        assertEquals(outputMoveRight, output)
    }

    @Test
    fun `should move west when turning left from north`() {
        val inputMoveLeft = "5 5\n1 2 N\nL"
        val outputMoveLeft = "1 2 W"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveLeft)

        assertEquals(outputMoveLeft, output)
    }

    @Test
    fun `should move south when turning left from west`() {
        val inputMoveLeft = "5 5\n1 2 W\nL"
        val outputMoveLeft = "1 2 S"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveLeft)

        assertEquals(outputMoveLeft, output)
    }

    @Test
    fun `should move east when turning left from south`() {
        val inputMoveLeft = "5 5\n1 2 S\nL"
        val outputMoveLeft = "1 2 E"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveLeft)

        assertEquals(outputMoveLeft, output)
    }

    @Test
    fun `should move north when turning left from east`() {
        val inputMoveLeft = "5 5\n1 2 E\nL"
        val outputMoveLeft = "1 2 N"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveLeft)

        assertEquals(outputMoveLeft, output)
    }

    @Test
    fun `should move north when ortientation is north`() {
        val inputMoveNorth = "5 5\n1 2 N\nM"
        val outputMoveNorth = "1 3 N"
        val rover = Rover()

        val output = rover.computeMoves(inputMoveNorth)

        assertEquals(outputMoveNorth, output)
    }

    /*5 5
1 2 N
LMLMLMLMM
1 3 N*/
}