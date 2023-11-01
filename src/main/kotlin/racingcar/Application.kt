package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val game = RacingCarGame()
    val carNames = game.inputCarNames()
    val attemptsCount = game.inputAttemptsCount()

}

class RacingCarGame {

    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = Console.readLine()
        val carNameList = carNames.split(',')
        validateCarName(carNameList)

        return carNameList
    }

    fun inputAttemptsCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val attemptsCount = Console.readLine()
        validateAttemptsCount(attemptsCount)
        return attemptsCount.toInt()
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

    private fun validateAttemptsCount(count: String) {
        if (count.isBlank()) {
            throw IllegalArgumentException("시도할 횟수를 입력해주세요.")
        }
        if (!count.matches(Regex("^-?\\d+\$")) || count.toInt() <= 0) {
            throw IllegalArgumentException("1 이상의 숫자를 입력해주세요.")
        }
    }

    fun printGameResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println("")

    }
}

class Car(val name: String) {
    private var position = 0

    fun move() {
        val randomValue = Randoms.pickNumberInRange(0, 9)

        if (randomValue >= 4) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }
}