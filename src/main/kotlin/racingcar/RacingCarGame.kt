package racingcar

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.max

class RacingCarGame(private val user: User) {
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val cars = user.requestInputCarNames()

        println("시도할 횟수는 몇 회인가요?")
        val moveCount = user.requestInputMoveCount()
        makeBlankLine()

        println("실행 결과")
        repeat(moveCount) { race(cars) }

        val winnerNames = decideWinners(cars)
        println("최종 우승자 : ${winnerNames.joinToString(", ")}")
    }

    private fun makeBlankLine() {
        println()
    }

    private fun race(cars: List<Car>) {
        cars.forEach {
            val randomNumber = Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER)
            it.tryMoveForward(randomNumber)
            showRaceMessage(it.name, randomNumber)
        }
        makeBlankLine()
    }

    private fun showRaceMessage(carName: String, randomNumber: Int) {
        println("$carName : ${"-".repeat(randomNumber)}")
    }

    private fun decideWinners(cars: List<Car>): List<String> {
        val maxForwardCount = cars.maxOf { it.forwardCount }
        val winners = cars.filter { it.forwardCount == maxForwardCount }
        return winners.map { it.name }
    }
}