package racingcar

class UserInput {
    private val restPointRegex = Regex("[^,]+")
    private val underFiveCharRegex = Regex("^.{1,5}\$")
    private val numberRegex = Regex("\\d+\$")

    fun inputCountMove(): Int {
        val input = readln().trim()
        checkIsNumber(input)
        return input.toInt()
    }
    private fun checkIsNumber(input: String) {
        if(!numberRegex.matches(input)){
            throw IllegalArgumentException("잘못된 입력")
        }
    }

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

    private fun checkRestPoint(input: String) {
        if ("," !in input) {
            throw IllegalArgumentException("잘못된 입력")
        }
    }




}