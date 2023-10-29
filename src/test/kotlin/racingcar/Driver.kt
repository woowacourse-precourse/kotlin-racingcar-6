package racingcar

import camp.nextstep.edu.missionutils.Console

class Driver {
    lateinit var carList: List<String>
    fun inputCarName(): List<String> {
        val carName = Console.readLine().split(",")
        carList = carName
        return carName
    }
    private fun checkCarNameExeption() {
        //자동차의 이름은 5자 이하만 가능, 자동차는 string만
        for (carName in carList) {
            if (carName.length !in 0..5) {
                IllegalArgumentException(ERROR_CAR_NAME_LENGTH)
            }
        }
    }



    companion object {
        const val ERROR_CAR_NAME_LENGTH = "자동차의 이름이 5자 이하가 아닙니다."
    }
}