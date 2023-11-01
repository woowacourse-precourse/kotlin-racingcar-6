package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView


class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        inputView.submitCarNames()
        val input = Console.readLine()
        val carList = makeCarList(input)
        outputView.startGameMessage()
        playWithCarList(carList, inputView.askTimes(), outputView)
        val winnerList = findWinner(carList)
        outputView.noticeWinner(winnerList)
    }

    private fun makeCarList(input: String?): MutableList<RacingCar> {
        val cars = input?.split(',')
        if (cars != null) {
            regexCheck(cars)
        } else {
            throw IllegalArgumentException()
        }
        val carList = mutableListOf<RacingCar>()
        for (car in cars) {
            carList.add(RacingCar(car, 0))
        }
        return carList
    }

    private fun regexCheck(cars: List<String>) {
        for (car in cars) {
            if (!car.matches(Regex("\\w{1,5}"))) {
                throw IllegalArgumentException()
            }
        }
    }

    private fun moveForwardOrNot(carList: MutableList<RacingCar>) {
        for (car in carList) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.moveForward()
            }
        }
    }

    private fun playWithCarList(carList: MutableList<RacingCar>, times: Int, outputView: OutputView) {
        for (i in 0 until times) {
            moveForwardOrNot(carList)
            outputView.printCurrentPlace(carList)
        }
    }

    private fun findWinner(carList: MutableList<RacingCar>): List<RacingCar> {
        val maxForward = carList.maxByOrNull { it.getForward() }?.getForward()
        return carList.filter { it.getForward() == maxForward }
    }
}