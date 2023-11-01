package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class User {
    companion object {
        const val MIN_ATTEMPT_NUMBER = 0
        const val MAX_ATTEMPT_NUMBER = 5
    }

    fun namingCar(): Map<String, Int> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carsName: String = Console.readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")

        validateNames(carsName)
        return carsName.split(",").associateWith { 0 }
    }

    fun attemptNumber(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")

        return validateAttemptNumber(input)
    }

    internal fun validateNames(names: String) {
        if (names.all { it == ',' })
            throw IllegalArgumentException("자동차의 이름이 입력되지 않았습니다.")

        val carNamesList = names.split(",")

        carNamesList.forEachIndexed { index, name ->
            if (name.isEmpty())
                throw IllegalArgumentException("${index + 1}번째 자동차 이름이 입력되지 않았습니다.")

        }

        if (carNamesList.any { it.length > MAX_ATTEMPT_NUMBER })
            throw IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.")

        if (carNamesList.distinct().size != carNamesList.size)
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")

    }

    internal fun validateAttemptNumber(input: String): Int {
        val number = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("유효하지 않은 입력입니다. 양의 정수를 입력해주세요.")
        }

        if (number <= MIN_ATTEMPT_NUMBER)
            throw IllegalArgumentException("시도 횟수는 양의 정수이어야 합니다.")

        return number
    }
}