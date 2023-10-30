package racingcar

import java.lang.IllegalArgumentException

class Validation {

    private val player = Player()

    private fun isValidNumberOfCars(carsNameList: List<String>) {
        if (carsNameList.size < 2) {
            throw IllegalArgumentException("자동차 이름은 2대 이상 입력해 주세요.")
        }
    }

    private fun checkContainsSpace(carsName: String) {
        if (carsName.contains(" ")) {
            throw IllegalArgumentException("공백은 들어갈 수 없습니다.")
        }
    }

    private fun checkCarNameDuplication(carsNameList: List<String>) {
        if (carsNameList.distinct().size != carsNameList.size) {
            throw IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해 주세요.")
        }
    }

    private fun checkCarNameLength(carsNameList: List<String>) {
        carsNameList.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다.")
            }
        }
    }

    fun isValidCarName() {
        val inputCarsName = player.inputCarName()
        val carList = inputCarsName.split(",")

        checkContainsSpace(inputCarsName)
        isValidNumberOfCars(carList)
        checkCarNameDuplication(carList)
        checkCarNameLength(carList)
    }

    private fun checkNumberOfAttemptOneAndMore(numberOfAttempt: Int) {
        if (numberOfAttempt < 1) {
            throw IllegalArgumentException("1 이상 입력 가능합니다")
        }
    }

    fun isValidNumberOfAttempt() {
        val numberOfAttempt = player.inputNumberOfAttempt()

        checkNumberOfAttemptOneAndMore(numberOfAttempt)
    }

}