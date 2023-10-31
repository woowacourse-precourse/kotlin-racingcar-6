package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun start() {
        outputView.printCarNameInputMention()
        val carList = getCarList(inputView.inputCarName())

        outputView.printRoundNumberInputMention()
        for (roundNumber in 0 until inputView.inputRoundNumber()) {
            for (car in carList) {
                moveOrStop(car, getRandomNumber())
            }

            if (roundNumber == 0) outputView.printResultMention()

            outputView.printResult(carList)
        }
        outputView.printWinner(getWinnerList(carList))
        inputView.closeConsole()
    }

    fun getCarList(carNameList: List<String>): List<Car> = carNameList.map { name -> Car(name) }

    private fun getRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    fun moveOrStop(car : Car, randomNumber: Int) {
        if (randomNumber >= 4) {
            car.move()
        }
    }

    fun getWinnerList(carList: List<Car>): List<Car> {
        val maxMove = carList.maxBy { car -> car.moves }.moves
        return carList.filter { car -> car.moves == maxMove }
    }
}