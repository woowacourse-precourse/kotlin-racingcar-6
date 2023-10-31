package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.Validator.validateDuplicate
import racingcar.Validator.validateNameLength
import racingcar.Validator.validateNull
import racingcar.Validator.validateNumber
import racingcar.Validator.validateRange

class RacingGame {
    companion object {
        private const val START_NUMBER = 0
        private const val COMPARE_NUMBER = 4
        private const val END_NUMBER = 9
    }

    private var gameCount = 0
    private val cars = Cars()
    private val carManager = CarManager()

    fun run() {
        initGame()
        gameStart()
        gameEnd()
    }

    private fun gameStart() {
        println("실행결과")
        repeat(gameCount) {
            runOneCycle()
        }
    }

    private fun gameEnd() {
        val winnerList = cars.getWinners()
        printWinner(winnerList)
    }

    //랜덤 숫자를 가져와 움직일 수 있는지 확인한다.
    //만약 움직일 수 있다면 자동차의 기존 이동거리에 1만큼 더한다.
    //그 후 자동차 이름과 함께 이동거리를 출력한다.
    private fun runOneCycle() {
        cars.list.forEach { car ->
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
        val carNameList = carManager.separateCarNames(inputCars())
        validateNameLength(carNameList)
        validateNull(carNameList)
        validateDuplicate(carNameList)

        //List<String> -> List<Car>
        return carManager.makeCarModelList(carNameList)
    }

    private fun inputRaceCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        validateNumber(input)
        validateRange(input)

        return input.toInt()
    }

    private fun getRandomNumber(): Int = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER)

    private fun checkMovable(number: Int): Boolean = number >= COMPARE_NUMBER

    private fun printCarDistance(car: Car) {
        println("${car.name} : ${"-".repeat(car.moveDistance)}")
    }

    private fun printWinner(winnerList: List<String>) {
        val winner = winnerList.joinToString(", ")
        println("최종 우승자 : $winner")
    }
}