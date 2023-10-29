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

    fun printPosition(cars: List<Car>) {
        println(ENTER_RESULT)
        for (car in cars) {
            println("${car.getName()} : ${car.getPosition()}")
        }
    }

    fun printWinner(winnerList: List<String>) {
        print(WINNER)
        val winner = winnerList.joinToString(", ")
        print(winner)
    }
}