package racingcar.console

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.validation.CheckValidation

object GameConsole {
    private val discriminator = CheckValidation()
    private var userInput = ""
    private val carList: MutableList<Car> = mutableListOf()
    private var racingCount = 0
    fun getCarList(): List<Car> = carList

    fun getCarCount(): Int = carList.size
    fun getRacingCount(): Int = racingCount

    fun separateCarList() {
        for (carName in userInput.split(",")) {
            discriminator.checkCarName(carName)
            registerCar((carName))
        }
    }

    fun setRacingCount() {
        discriminator.checkInputRacingCount(userInput)
        racingCount = userInput.toInt()
    }

    private fun registerCar(carName: String) =
        carList.add(Car(carName))

    fun getUserInput() {
        userInput = Console.readLine()
    }
}