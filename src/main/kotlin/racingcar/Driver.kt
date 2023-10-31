package racingcar

class Driver {

    fun decideMovement() {

    }

    private fun checkIsGoToStop(randomNum: Int): String {
        val num = when (randomNum) {
            in 0..4 -> STOP
            else -> GO
        }
        return num
    }

    companion object {
        const val STOP = ""
        const val GO = "-"
    }
}