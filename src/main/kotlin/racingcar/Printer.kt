package racingcar

import java.lang.StringBuilder

class Printer {
    fun printList(carList: List<Car>) {
        for (item in carList) {
            print(item)
        }
    }

    private fun print(car: Car) {
        val stringBuilder = StringBuilder()

        stringBuilder.append(car.name + " : ")
        for (i in 1..car.location) {
            stringBuilder.append('-')
        }
        println(stringBuilder)
    }

    fun printWinner(carList: List<Car>) {
        val stringBuilder = StringBuilder()
        carList.map {
            stringBuilder.append(it.name + ", ")
        }
        stringBuilder.trim()
        println(Const.WINNER_MSG + stringBuilder.substring(0,stringBuilder.lastIndex-1))
    }
}