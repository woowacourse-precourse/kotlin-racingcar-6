package racingcar

import camp.nextstep.edu.missionutils.Console

class Car {

    fun createCar(): List<String> {

        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

        return (Console.readLine() ?: "").split(",")
    }

    fun validateCarNameLength(carNames : List<String>) {
        if (carNames.any { it.length > 5 }) throw IllegalArgumentException("자동차 이름의 길이가 5가 넘습니다.")
    }

    fun validateDuplicateName(carNames : List<String>) {
        if (carNames.size != carNames.distinct().size) throw IllegalArgumentException("자동차 이름에 중복이 있습니다.")
    }

    fun validateBlankName(carNames : List<String>) {
        if (carNames.any { it.isBlank() }) throw IllegalArgumentException("자동차 이름이 공백입니다.")
    }

    fun createCarProgressList(carNames: List<String>) : MutableList<Int> {
        return MutableList<Int>(carNames.size) { 0 }
    }
}