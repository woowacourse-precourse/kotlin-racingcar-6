package racingcar

import camp.nextstep.edu.missionutils.Console

class View {
    fun enterNames(): String {
        println(ENTER_CAR_NAME)
        return Console.readLine()
    }

    fun enterNumberTimes(): String {
        println(ENTER_NUMBER_TIMES)
        return Console.readLine()
    }

    fun printResult() {
        println("\n${ENTER_RESULT}")
    }

    fun printPosition(cars: List<Car>) {
        for (car in cars) {
            println("${car.getName()} : ${car.getPosition()}")
        }
        println()
    }

    fun printWinner(winnerList: List<String>) {
        val winner = winnerList.joinToString(", ")
        print("$WINNER$winner")
    }
}