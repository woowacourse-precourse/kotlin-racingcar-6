package racingcar

import racingcar.Car.Companion.GO
import racingcar.Car.Companion.STOP

class Game {
    lateinit var carNameList: List<String>
    val ERROE_GO_TO_STOP = "0~9가 아닌 값"
    var tryGameNum: Int = 0
    fun playGame() {
        playUser()
        playCar()
    }

    private fun playUser() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        carNameList = Driver().inputCarName()
        Driver().checkCarNameExeption()
        println("시도할 횟수는 몇 회인가요?")
        tryGameNum = Driver().inputTryGame()
    }

    private fun playCar() {
        println("실행 결과")
        playResult()

    }

    private fun playResult() {
        for (carName in carNameList) {
            print("$carName : ")
            print("${printPlayLine()}")
            println()
        }
    }

    private fun printPlayLine(): String {
        val randomNum = Car().generatorRandomNum()
        val goList = Car().checkIsGoToStop(randomNum)

        return when (goList) {
            GO -> "-"
            STOP -> ""
            else -> throw IllegalArgumentException(ERROE_GO_TO_STOP)
        }
    }

}