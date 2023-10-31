package racingcar.Controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller(val inputView: InputView, val outputView: OutputView) {
    fun startGame(){
        inputView.printStartGameMessage()
        val carNames : List<String> = inputView.inputRacingCarName()
        inputView.printAskTryNumberMessage()
        val tryNumber = inputView.inputTryNumber()

        outputView.printResultMessage()
        val racingCars = makeRacingCars(carNames)
        for (index in 1..tryNumber)
            println(outputView.printResult(moveOrStop(racingCars)))

        outputView.printWinnerMessage()
        println(outputView.printWinner(getWinnerForward(racingCars)))
    }

    fun makeRacingCars(carNames: List<String>) : List<RacingCar> {
        val racingCars = mutableListOf<RacingCar>()
        for (car in carNames.indices) {
            racingCars.add(RacingCar(carNames[car]))
        }
        return racingCars
    }

    fun moveOrStop(racingCars: List<RacingCar>) : List<RacingCar> {
        for (car in racingCars.indices) {
            val randomNumber = getRandomNumber()
            if (validateMoreThanFour(randomNumber)) racingCars[car].forward++
        }
        return racingCars
    }

    fun getRandomNumber() : Int = Randoms.pickNumberInRange(0, 9)

    fun validateMoreThanFour(randomNumber: Int) : Boolean = randomNumber >= 4

    fun getWinnerForward(racingCars: List<RacingCar>) : List<String> {
        val sortedRacingCars = racingCars.sortedByDescending { it.forward }
        val winnerForward = sortedRacingCars[0].forward
        return getWinnerCars(winnerForward, sortedRacingCars)
    }

    fun getWinnerCars(winnerForward: Int, sortedRacingCars: List<RacingCar>) : List<String> {
        val winnerCars = mutableListOf<String>()
        for (car in sortedRacingCars) {
            if(car.forward == winnerForward) winnerCars.add(car.name)
        }
        return winnerCars
    }
}