package racingcar

import java.lang.IllegalArgumentException

class Validation(player: Player) {

    private val inputCarsName = player.inputCarName()
    private val carList = inputCarsName.split(",")

    fun isValidNumberOfCars() {
        if (!inputCarsName.contains(",")) {
            throw IllegalArgumentException("자동차 이름은 2대 이상 입력해 주세요.")
        }
    }

    fun checkContainsSpace() {
        if (inputCarsName.contains(" ")) {
            throw IllegalArgumentException("공백은 들어갈 수 없습니다.")
        }
    }

    fun checkCarNameDuplication() {
        if (carList.distinct().size != carList.size) {
            throw IllegalArgumentException("중복된 이름은 입력할 수 없습니다.")
        }
    }

    fun checkCarNameLength() {
        carList.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다.")
            }
        }
    }
}