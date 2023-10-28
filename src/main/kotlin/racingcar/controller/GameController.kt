package racingcar.controller

import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    private val winningCarMembers = mutableListOf<String>()
    fun start() {
        val carMembers = InputView.inputCarName()
        val numberAttempts = InputView.inputNumberAttempts().toInt()
        val carList = generateCarList(carMembers)

        OutputView.printExecutionResultText()
        executeGame(carList, numberAttempts)
        findWinningMember(carList)
        OutputView.printGameResult(winningCarMembers)
    }

    private fun findWinningMember(carList: MutableList<Car>) {
        for (car in carList) {
            if (car.moveCount == findMaximumMove(carList)) {
                winningCarMembers.add(car.carName)
            }
        }
    }

    private fun executeGame(carList: MutableList<Car>, numberAttempts: Int) {
        for (attemptCountIndex in 0 until numberAttempts) {
            moveCar(carList)
            OutputView.printExecutionResult(carList)
        }
    }

    private fun moveCar(carList: MutableList<Car>) {
        for (carListIndex in carList.indices) {
            carList[carListIndex].move()
        }
    }

    private fun generateCarList(carMembers: List<String>): MutableList<Car> {
        val carList = mutableListOf<Car>()
        for (carName in carMembers) {
            carList.add(Car(carName))
        }
        return carList
    }

    private fun findMaximumMove(cars: List<Car>): Int? {
        val movementList = mutableListOf<Int>()
        for (car in cars) {
            movementList.add(car.moveCount)
        }
        return movementList.maxOrNull()
    }
}