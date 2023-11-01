package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

class RacingGame {
    private val cars: MutableList<Car> = mutableListOf()
    private lateinit var winner: String

    fun gameStart() {
        getRacer()
        val round = getRound()
    }

    private fun getRacer() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val racers = Console.readLine().split(',')
        for (racer in racers) {
            cars.add(Car(racer))
        }
    }

    private fun getRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val round = Console.readLine()
        return validateRound(round)
    }

    private fun validateRound(round: String): Int {
        return try {
            round.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("잘못된 라운드를 입력하였습니다.")
        }
    }
}