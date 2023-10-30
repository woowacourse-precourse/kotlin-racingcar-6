package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Cars

class ScreenView {
    private val inputCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private val inputGameCountMessage = "시도할 횟수는 몇 회인가요?"

    fun inputCarName(): String {
        println(inputCarNameMessage)
        return inputUserCarForWait()
    }

    fun inputGameCount() {
        println(inputGameCountMessage)
    }

    private fun inputUserCarForWait(): String {
        return Console.readLine()?.toString() ?: throw IllegalArgumentException("올바른 형식으로 입력해주세요.")
    }


    fun printTrace(cars: Cars) {
        cars.cars.forEach { car ->
            print("${car.name} : ")
            println("-".repeat(car.distance))
        }
        print("\n")
    }
}