package racingcar

class Car(val carName: String, val randomNum: Int) {
    var distance = ""

    fun checkIsGoToStop(advanceNum: Int): String {
        return when (advanceNum) {
            in 0..4 -> STOP
            else -> GO
        }
    }

    private fun printPlayLine(randomNum: Int): String {

        return when (checkIsGoToStop(randomNum)) {
            GO -> "-"
            STOP -> ""
            else -> throw IllegalArgumentException(ERROE_GO_TO_STOP)
        }
    }

    fun carMove() {
        val progress = printPlayLine(randomNum)
        distance += progress
        print(distance)
    }


    companion object {
        const val STOP = "STOP"
        const val GO = "GO"
        const val ERROE_GO_TO_STOP = "0~9가 아닌 값"
    }
}