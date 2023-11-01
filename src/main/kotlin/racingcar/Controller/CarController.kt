package racingcar.Controller

import racingcar.Model.CarModel
import racingcar.View.CarView

class CarController(val view: CarView, val model: CarModel) {
    fun startGame() {

        val carNameInput = carName()
        model.carNameLimit(carNameInput)

        val tryCountInput = tryCount()
        if (tryCountInput <= 0) {
            throw IllegalArgumentException("시도 횟수는 0보다 커야 합니다.")
        }

        val carMove = mutableMapOf<String, Int>()
        for (i in 1..tryCountInput) {
            println()
            moveCar(carNameInput, carMove)
        }

        val winners = winnersList(carMove)
        printWinners(winners)

    }
    private fun carName(): List<String> {
        view.printCarNamesMessage()
        val carName = readLine()
        return carName?.split(",") ?: throw IllegalArgumentException("올바르게 다시 입력해주세요")
    }

    private fun tryCount():Int{
        view.printTryCountMessage()
        val tryCountInput = readLine()!!.toInt()
        return tryCountInput
    }

    private fun moveCar(carNameInt: List<String>, carMove: MutableMap<String,Int>){
        for (car in carNameInt) {
            if ((0..9).random() >= 4) {
                carMove[car] = (carMove[car] ?: 0) + 1
            }
        }
        for (car in carNameInt) {
            val distance = carMove[car] ?: 0
            view.printMoveCar(car,distance)
        }
    }
    private fun winnersList(carMove: MutableMap<String, Int>):List<String> {
        var maxMove = 0
        for ((_, distance) in carMove) {
            if (distance > maxMove) {
                maxMove = distance
            }
        }

        val winners = mutableListOf<String>()
        for ((car, distance) in carMove) {
            if (distance == maxMove) {
                winners.add(car)
            }
        }
        return winners
    }
    private fun printWinners(winners: List<String>){
        view.printWinnersMessage(winners.joinToString(", "))
    }
}