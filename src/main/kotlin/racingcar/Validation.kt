package racingcar

import java.lang.IllegalArgumentException

class Validation {

    private fun isValidNumberOfCars(carsNameList: List<Car>) {
        if (carsNameList.size < 2) {
            throw IllegalArgumentException("자동차 이름은 2대 이상 입력해 주세요.")
        }
    }

    private fun checkContainsSpace(carsName: String) {
        if (carsName.contains(" ")) {
            throw IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해 주세요.")
        }
    }

    private fun checkCarNameDuplication(carsNameList: List<Car>) {
        if (carsNameList.distinct().size != carsNameList.size) {
            throw IllegalArgumentException("중복된 이름은 작성할 수 없습니다.")
        }
    }

    private fun checkCarNameLength(carsNameList: List<Car>) {
        carsNameList.forEach {
            if (it.name.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다.")
            }
        }
    }

    fun isValidCarName(carsName: String, carList: List<Car>) {
        checkContainsSpace(carsName)
        isValidNumberOfCars(carList)
        checkCarNameDuplication(carList)
        checkCarNameLength(carList)
    }

    fun checkNumberOfAttemptOneAndMore(numberOfAttempt: Int) {
        if (numberOfAttempt < 1) {
            throw IllegalArgumentException("1 이상 입력 가능합니다")
        }
    }

}