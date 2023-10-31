package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.exception.IllegalNameException
import racingcar.exception.IllegalNumberException
import racingcar.model.RacingCarGenerator
import racingcar.model.RacingCars

class InputView {
    private val racingCarGenerator = RacingCarGenerator()
    private fun inputCarName(racingCars: RacingCars) {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        try {
            val cars = Console.readLine()!!.split(",")
            addRacingCars(racingCars, cars)
        } catch (e: Exception) {
            throw IllegalNameException()
        }
    }

    private fun addRacingCars(racingCars: RacingCars, cars: List<String>) {
        for (car in cars.indices) {
            val newCar = racingCarGenerator.addCar(cars[car])
            racingCars.add(newCar)
        }
    }

    private fun inputTryCount(racingCars: RacingCars) {
        try {
            println("시도할 횟수는 몇 회인가요?")
            racingCars.tryCnt = Console.readLine()!!.toInt()
        } catch (e: Exception) {
            throw IllegalNumberException()
        }
    }

    fun prepareToPlay(): RacingCars {
        val racingCars = RacingCars()
        inputCarName(racingCars)
        inputTryCount(racingCars)
        return racingCars
    }
}
