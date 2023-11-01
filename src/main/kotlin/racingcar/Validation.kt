package racingcar

import kotlin.IllegalArgumentException

class Validation {

    fun isValidNumberOfCars(carsNameList: List<Car>) {
        if (carsNameList.size < 2) {
            throw IllegalArgumentException("자동차 이름은 2대 이상 입력해 주세요.")
        }
    }

    fun checkContainsSpace(carsName: String) {
        if (carsName.contains(" ")) {
            throw IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해 주세요.")
        }
    }

    fun checkCarNameDuplication(carsNameList: List<Car>) {
        val names = carsNameList.map { it.name }
        if (names.distinct().size != names.size) {
            throw IllegalArgumentException("중복된 이름은 작성할 수 없습니다.")
        }
    }

    fun checkCarNameLength(carsNameList: List<Car>) {
        carsNameList.forEach {
            if (it.name.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다.")
            }
        }
    }

    fun checkCarNameBlank(carsNameList: List<Car>) {
        if (carsNameList.any { it.name == "" }) {
            throw IllegalArgumentException("자동차 이름은 공백일 수 없습니다.")
        }
    }

    fun isValidCarName(carsName: String, carList: List<Car>) {
        checkContainsSpace(carsName)
        isValidNumberOfCars(carList)
        checkCarNameBlank(carList)
        checkCarNameDuplication(carList)
        checkCarNameLength(carList)
    }

    fun checkNumberOrNot(numberOfAttempt: String): Int {
        return try {
            numberOfAttempt.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자만 입력하세요")
        }
    }

    fun checkNumberOfAttemptOneAndMore(numberOfAttemptToInt: Int) {
        if (numberOfAttemptToInt < 1) {
            throw IllegalArgumentException("1 이상 입력 가능합니다")
        }
    }

}