package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val game = RacingCarGame()
    game.inputCarNames()
}

class RacingCarGame {

    fun inputCarNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = Console.readLine()
        val carNameList = carNames.split(',')
        validateCarName(carNameList)
    }

    private fun validateCarName(carNameList: List<String>) {

        carNameList.forEach { carName ->
            if (carName.isBlank()) {
                throw IllegalArgumentException("자동차 이름을 입력해주세요.")
            }
            if (carName.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.")
            }
        }
    }
}