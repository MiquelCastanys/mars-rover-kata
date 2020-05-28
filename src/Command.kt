import java.lang.IllegalArgumentException

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