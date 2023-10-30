package racingcar

import java.lang.IllegalArgumentException

class Validation(private val player: Player) {

    private val inputCarsName = player.inputCarName()

    fun isValidNumberOfCars() {
        if (!inputCarsName.contains(",")) {
            throw IllegalArgumentException("자동차 이름은 2대 이상 입력해 주세요.")
        }
    }

}