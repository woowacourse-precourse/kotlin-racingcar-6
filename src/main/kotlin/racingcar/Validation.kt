package racingcar

import java.lang.IllegalArgumentException

class Validation {

    fun isValidNumberOfCars(carsNameList: List<String>) {
        if (carsNameList.size < 2) {
            throw IllegalArgumentException("자동차 이름은 2대 이상 입력해 주세요.")
        }
    }

    fun checkContainsSpace(carsName: String) {
        if (carsName.contains(" ")) {
            throw IllegalArgumentException("공백은 들어갈 수 없습니다.")
        }
    }

    fun checkCarNameDuplication(carsNameList: List<String>) {
        if (carsNameList.distinct().size != carsNameList.size) {
            throw IllegalArgumentException("중복된 이름은 입력할 수 없습니다.")
        }
    }

    fun checkCarNameLength(carsNameList: List<String>) {
        carsNameList.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다.")
            }
        }
    }

}