package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.Validator.validateDuplicate
import racingcar.Validator.validateNameLength
import racingcar.Validator.validateNull
import racingcar.Validator.validateNumber

class RacingGame {
    lateinit var carModelList: List<Car>
    var gameCount = 0

    fun run() {
        initGame()
        gameStart()
        gameEnd()
    }

    fun gameStart() {
        println("실행결과")
        repeat(gameCount) {
            runOneCycle(carModelList)
        }

    }

    fun gameEnd() {
        val winnerList = getWinner(carModelList)
        printWinner(winnerList)
    }

    fun runOneCycle(carModelList: List<Car>) {
        carModelList.forEach { car ->
            val isMovable = checkMovable(getRandomNumber())
            car.moveOneStep(isMovable)
            printCarDistance(car)
        }
        println()
    }

    fun initGame() {
        carModelList = inputCarNames()
        gameCount = inputRaceCount()
    }

    fun inputCars(): String = Console.readLine()


    fun inputCarNames(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNameList = separateCarNames(inputCars())
        validateNameLength(carNameList)
        validateNull(carNameList)
        validateDuplicate(carNameList)
        return makeCarModelList(carNameList)
    }

    fun separateCarNames(carNames: String): List<String> = carNames.split(",")


    fun makeCarModelList(carNames: List<String>): List<Car> {
        var modelList = mutableListOf<Car>()
        carNames.forEach {
            modelList.add(Car(it))
        }

        return modelList.toList()
    }

    fun inputRaceCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        validateNumber(input)

        return input.toInt()
    }

    fun getRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    fun checkMovable(number: Int): Boolean = number >= 4

    fun printCarDistance(car: Car) {
        println("${car.name} : ${"-".repeat(car.moveDistance)}")
    }

    fun getWinner(carModelList: List<Car>): MutableList<String> {
        val nameList = carModelList.map { it.name }
        val distanceList = carModelList.map { it.moveDistance }

        return findWinner(nameList, distanceList)
    }

    fun findWinner(nameList: List<String>, distanceList: List<Int>): MutableList<String> {
        var winnerList = mutableListOf<String>()
        val maxDistance = distanceList.max()

        for (i in distanceList.indices) {
            if (distanceList[i] == maxDistance) {
                winnerList.add(nameList[i])
            }
        }

        return winnerList
    }

    fun printWinner(winnerList: MutableList<String>) {
        val winner = winnerList.joinToString(", ")
        println("최종 우승자 : $winner")
    }
}