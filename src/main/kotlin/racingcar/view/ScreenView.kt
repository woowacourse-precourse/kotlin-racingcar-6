package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.model.Winners

class ScreenView {
    private val inputCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private val inputGameCountMessage = "시도할 횟수는 몇 회인가요?"

    fun inputCarName(): List<String> {
        println(inputCarNameMessage)
        return inputUserCarForWait()
    }

    fun inputGameCount(): Int {
        println(inputGameCountMessage)
        val gameCount = Console.readLine()?.toInt()
        if (gameCount != null) {
            if (gameCount < 0) {
                throw IllegalArgumentException("0 이상의 정수를 입력해주세요.")
            } else {
                return gameCount
            }
        } else {
            throw IllegalArgumentException("횟수를 입력해주세요.")
        }
    }

    private fun inputUserCarForWait(): List<String> {
        val carNames = Console.readLine()?.toString()
        if (carNames != null) {
            val carList = carNames.split(",")
            if (carList.size != carList.distinct().count()) {
                throw IllegalArgumentException("중복된 이름이 존재합니다.")
            } else {
                return carList
            }
        } else {
            throw IllegalArgumentException("자동차 이름을 입력해주세요.")
        }
    }


    fun printTrace(cars: MutableList<Car>) {
        cars.forEach { car ->
            print("${car.name} : ")
            println("-".repeat(car.distance))
        }
        print("\n")
    }

    fun printWinners(winners: Winners) {
        print("최종 우승자 : ")
        for (i in winners.winners) {
            print(i.name)
            if (i != winners.winners.last()) {
                print(", ")
            }
        }
    }
}
