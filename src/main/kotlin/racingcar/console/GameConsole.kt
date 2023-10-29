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

    fun getRacingCount(): Int = racingCount

    fun separateCarList() {
        for (carName in userInput.split(",")) {
            discriminator.checkCarName(carName)
            registerCar((carName))
        }
    }

    fun selectWinner() : List<String>{
        return carList
            .groupBy { it.progress }// progress 기준으로 mapping
            .maxBy { it.key } // 키(progress) 기준으로 가장 큰 값 선별
            .value.map { it.name } // 가장 큰 키의 Car name list 리턴
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