package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        outputView.printCarNameInputMention()
        val carList = getRacingCarList(inputView.inputCarName())

        outputView.printRoundNumberInputMention()
        for (attemptNumber in 0 until inputView.inputRoundNumber()) {
            for (car in carList) {
                moveOrStop(car, getRandomNumber())
            }

            if (attemptNumber == 0) outputView.printResultMention()

            outputView.printResult(carList)
        }
        outputView.printWinner(getWinnerList(carList))
        inputView.closeConsole()
    }

   fun getRacingCarList(carNameList: List<String>): List<RacingCar> = carNameList.map { name -> RacingCar(name) }

    fun getRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    fun moveOrStop(racingCar : RacingCar, randomNumber: Int) {
        if (randomNumber >= 4) {
            racingCar.move()
        }
    }

    fun getWinnerList(racingCarList: List<RacingCar>): List<RacingCar> {
        val maxMove = racingCarList.maxBy { car -> car.moves }.moves

        return racingCarList.filter { car -> car.moves == maxMove }
    }
}