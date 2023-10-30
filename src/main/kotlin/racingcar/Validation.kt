package racingcar

import java.lang.IllegalArgumentException

class Validation(private val player: Player) {

    private val inputCarsName = player.inputCarName()

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
        val list = inputCarsName.split(",")
        if (list.distinct().size != list.size) {
            throw IllegalArgumentException("중복된 이름은 입력할 수 없습니다.")
        }
    }
    
}