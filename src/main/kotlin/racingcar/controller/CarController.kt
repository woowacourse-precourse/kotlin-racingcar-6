package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.validator.InputValidator
import racingcar.data.Car

class CarController {

    private val cars = mutableListOf<Car>()

    fun getCars(): List<Car> = cars.toList()

    fun createCars(input: String) {
        input.split(",").forEach { name ->
            validCreateCars(name)
            cars.add(Car(name))
        }
    }

    private fun validCreateCars(name: String) {
        with(InputValidator) {
            checkCarNameLength(name)
            checkInputWhitespace(name.trim())
        }
    }

    fun moveCarsForward(cars: List<Car>): List<Car> {
        cars.forEachIndexed { index, _ ->
            if (isCarMovingAllowed(generateRandomNumber())) {
                increaseCarDistance(index)
            }
        }

        return cars.toList()
    }

    private fun isCarMovingAllowed(randomNumber: Int): Boolean = when (randomNumber) {
        in 4..9 -> true
        else -> false
    }

    private fun increaseCarDistance(index: Int) {
        val oldCar = cars[index]
        cars[index] = oldCar.copy(distance = oldCar.distance + 1)
    }

    fun findWinners(): List<String> {
        val maxDistanceCar = findMaxDistanceCar()

        val winners = cars.filter { car ->
            car.distance == maxDistanceCar?.distance
        }

        return winners.map { it.name }
    }

    private fun findMaxDistanceCar(): Car? {
        return cars.maxByOrNull { car -> car.distance }
    }

    fun inputCarNameFromUser(): String {
        val carName = Console.readLine()

        validInputCarName(carName)

        return carName
    }

    private fun validInputCarName(carName: String) {
        with(InputValidator) {
            checkInputNonBlank(carName)
            checkInputOverSize(carName.split(",").size)
            checkCarMinSize(carName)
            checkInputPrefix(carName[0])
            checkInputPostfix(carName[carName.lastIndex])
        }
    }

    private fun generateRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)
}