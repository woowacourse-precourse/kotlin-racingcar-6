package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    RacingCarGame().start()
}

class RacingCarGame {

    fun start() {
        val carNames = inputCarNames()
        val attemptsCount = inputAttemptsCount()

        val cars = carNames.map { Car(it) }

        println("\n실행 결과")
        repeat(attemptsCount) {
            for (car in cars) {
                car.move()
            }
            printGameResult(cars)
        }
        printWinners(findWinners(cars))
    }

    private fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = Console.readLine()
        val carNameList = carNames.split(',')
        validateCarName(carNameList)

        return carNameList
    }

    private fun inputAttemptsCount(): Int {
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

    private fun printGameResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }

    private fun findWinners(cars: List<Car>): List<String> {
        var maxPosition: Int? = null
        val winnerNames = mutableListOf<String>()

        for (car in cars) {
            val position = car.getPosition()

            if (maxPosition == null || position > maxPosition) {
                maxPosition = position
                winnerNames.clear()
            }

            if (position == maxPosition) {
                winnerNames.add(car.name)
            }
        }
        return winnerNames
    }

    private fun printWinners(winners: List<String>) {
        val winnerMessage = "최종 우승자 : ${winners.joinToString(", ")}"
        println(winnerMessage)
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