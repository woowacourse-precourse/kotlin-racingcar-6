package racingcar.View

import Car
import RacingGameModel
import carExceptions
import playTimeExceptions

object RacingGameView {
    fun inputCarNames() : RacingGameModel {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = readLine()

        return carExceptions.checkInputIsValid(input);
    }

    fun inputPlayTime() : Int  {
        println("시도할 횟수는 몇 회인가요?")
        val playTime = readLine()

        return playTimeExceptions.checkPlayTimeIsInvalid(playTime)
    }

    fun printPlayResultText(){
        println("\n실행 결과")
    }

    fun printCount(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.count)}")
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(",")}")
    }
}