package racingcar.domain

import racingcar.model.Car
import racingcar.util.Const
import racingcar.io.Input
import racingcar.io.Printer
import racingcar.io.checker.CarNameExceptionChecker
import racingcar.io.checker.LoopCountExceptionChecker

class GameHost {
    fun start() {
        val inputModule = Input()
        println(Const.START_MSG)
        val inputString = inputModule.getInput(CarNameExceptionChecker())
        val carList = inputString.split(",").map {
            Car(it)
        }

        println(Const.LOOP_MSG)
        val loopString = inputModule.getInput(LoopCountExceptionChecker())
        val loop = loopString.toInt()
        println()
        println(Const.LOOP_START_MSG)

        runGame(loop, carList)

        val winnerList = findWinner(carList)

        val printer = Printer()
        printer.printWinner(winnerList)
    }

    private fun findWinner(carList: List<Car>): List<Car> {
        val maxCar = carList.maxBy {
            it.location
        }

        val winnerList = carList.filter {
            it.location == maxCar.location
        }

        return winnerList
    }


    private fun runGame(loop: Int, carList: List<Car>) {
        val printer = Printer()
        for(i in 1..loop){
            carList.map {
                it.move()
            }

            printer.printList(carList)
            println()
        }
    }
}