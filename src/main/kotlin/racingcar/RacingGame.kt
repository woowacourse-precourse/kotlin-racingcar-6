package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.Validator.validateDuplicate
import racingcar.Validator.validateNameLength
import racingcar.Validator.validateNull
import racingcar.Validator.validateNumber

class RacingGame {
    var gameCount = 0
    private val cars = Cars()

    fun run() {
        initGame()
        gameStart()
        gameEnd()
    }

    private fun gameStart() {
        println("실행결과")
        repeat(gameCount) {
            runOneCycle(cars.list)
        }
    }

    private fun gameEnd() {
        val winnerList = cars.getWinners()
        printWinner(winnerList)
    }

    private fun runOneCycle(carModelList: List<Car>) {
        carModelList.forEach { car ->
            val isMovable = checkMovable(getRandomNumber())
            car.moveOneStep(isMovable)
            printCarDistance(car)
        }
        println()
    }

    private fun initGame() {
        val carModelList = inputCarNames()
        cars.addAllList(carModelList)
        gameCount = inputRaceCount()
    }

    private fun inputCars(): String = Console.readLine()

    private fun inputCarNames(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNameList = separateCarNames(inputCars())
        validateNameLength(carNameList)
        validateNull(carNameList)
        validateDuplicate(carNameList)
        return makeCarModelList(carNameList)
    }

    private fun separateCarNames(carNames: String): List<String> = carNames.split(",")

    private fun makeCarModelList(carNames: List<String>): List<Car> {
        var modelList = mutableListOf<Car>()
        carNames.forEach {
            modelList.add(Car(it))
        }
        return modelList.toList()
    }

    private fun inputRaceCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        validateNumber(input)

        return input.toInt()
    }

    private fun getRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    private fun checkMovable(number: Int): Boolean = number >= 4

    private fun printCarDistance(car: Car) {
        println("${car.name} : ${"-".repeat(car.moveDistance)}")
    }

    private fun printWinner(winnerList: List<String>) {
        val winner = winnerList.joinToString(", ")
        println("최종 우승자 : $winner")
    }
}