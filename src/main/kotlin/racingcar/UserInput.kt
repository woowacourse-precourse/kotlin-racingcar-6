package racingcar

class UserInput {
    private val restPointRegex = Regex("[^,]+")
    private val underFiveCharRegex = Regex("^.{1,5}\$")
    fun inputCarNames(): List<Car> {
        val input = readln().trim()
        checkRestPoint(input)
        checkUnderFiveCharRegex(input)
        return convertInputToCarList(input)
    }

    private fun convertInputToCarList(input: String): List<Car> {
        return restPointRegex.findAll(input).map { Car(it.value) }.toList()
    }

    private fun checkUnderFiveCharRegex(input: String) {
        val cars = restPointRegex.findAll(input)
        for (car in cars) {
            if (!underFiveCharRegex.matches(car.value)) {
                throw IllegalArgumentException("잘못된 입력")
            }
        }
    }

    fun checkRestPoint(input: String) {
        if (!restPointRegex.matches(input)) {
            throw IllegalArgumentException("잘못된 입력")
        }
    }


}