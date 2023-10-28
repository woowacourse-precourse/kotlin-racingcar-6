package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingCarController(private val racingCarGame: RacingCarGame = RacingCarGame()) {

    private val cars = mutableListOf<CarModel>()
    private var trialCount = 0

    fun playGame() {
        // 입력 받기
        getInputs()

        // 실행 결과 출력
        println("\n실행 결과")
        repeat(trialCount) {
            tryRacing()
            println()
        }

        // 최종 우승자 판단
        findWinners()

        // 최종 우승자 출력
        printWinners()
        Console.close()
    }

    private fun getInputs() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val getNames = Console.readLine()
        isNameWrong(getNames)

        println("시도할 횟수는 몇 회인가요?")
        trialCount = isTrialCountWrong(Console.readLine())
    }

    private fun isNameWrong(input: String) {
        val nameList = input.split(",")
        for (name in nameList) {
            if (name.length > 5) throw IllegalArgumentException()
            cars.add(CarModel(name))
        }
    }

    private fun isTrialCountWrong(input: String): Int {
        val inputToInt: Int
        try {
            inputToInt = input.toInt()
        } catch (e: java.lang.NumberFormatException) {
            throw IllegalArgumentException()
        }
        return inputToInt
    }

    private fun tryRacing() {
        for (car in cars){
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.moveForward()
            }
            car.printPresentDistance()
        }
    }

    private fun findWinners() {
        for (car in cars) {
            if (car.getDistance() == racingCarGame.getWinningDistance())
                racingCarGame.addWinner(car.getName())

            if (car.getDistance() > racingCarGame.getWinningDistance())
                racingCarGame.changeWinner(car.getName(), car.getDistance())
        }
    }

    private fun printWinners() = println("최종 우승자 : ${racingCarGame.getWinnersListAsString()}")
}