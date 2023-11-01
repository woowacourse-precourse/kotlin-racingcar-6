package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class User {

    fun namingCar(): Map<String, Int> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carsName: String = Console.readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")
        validateNames(carsName)
        return carsName.split(",").map { it }.associateWith { 0 }
    }

    fun attemptNumber(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toInt()
    }

    private fun validateNames(names: String) {
        if (names.all { it == ',' }) {
            throw IllegalArgumentException("유효하지 않은 입력입니다. 자동차 이름을 제대로 입력해주세요.")
        }

        val carNamesList = names.split(",")

        if (carNamesList.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.")
        }

        if (carNamesList.distinct().size != carNamesList.size) {
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
        }
    }
}