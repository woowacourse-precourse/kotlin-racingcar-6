package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val game = RacingCarGame()
    game.inputCarNames()
    game.inputAttemptsCount()
}

class RacingCarGame {

    fun inputCarNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = Console.readLine()
        val carNameList = carNames.split(',')
        validateCarName(carNameList)
    }

    fun inputAttemptsCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toInt()
    }

    private fun validateCarName(carNameList: List<String>) {
        val uniqueCarNames = HashSet<String>()

        carNameList.forEach { carName ->
            if (carName.isBlank()) {
                throw IllegalArgumentException("자동차 이름을 입력해주세요.")
            }
            if (carName.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.")
            }
            if (!uniqueCarNames.add(carName)) {
                throw IllegalArgumentException("중복된 자동차 이름 : $carName")
            }
        }
    }
}