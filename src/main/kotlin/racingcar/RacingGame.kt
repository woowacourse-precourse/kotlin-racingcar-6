package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

class RacingGame {
    private val cars: MutableList<Car> = mutableListOf()

    fun gameStart() {
        getRacer()
        val round = getRound()
        println("실행 결과")
        for (i in 0 until round) {
            move()
        }
        printResult()
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

    fun move() {
        for (car in cars) {
            car.move()
        }
        println()
    }

    fun printResult() {
        val progress = mutableListOf<Int>()
        for (car in cars) {
            progress.add(car.progress)
        }
        showWinner(progress.max())
    }

    private fun showWinner(maxValue: Int) {
        val result = cars.filter { it.progress == maxValue }
        print("최종 우승자 : ")
        var win: String = result[0].name
        if(result.size > 1) {
            for (winner in result.subList(1, result.size)) {
                win = win + ", " + winner.name
            }
        }
        println(win)
    }
}