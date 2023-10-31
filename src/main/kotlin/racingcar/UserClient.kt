package racingcar

class UserClient {
    private val restPointRegex = Regex("[^,]+")
    private val underFiveCharRegex = Regex("^.{1,5}\$")
    private val numberRegex = Regex("\\d+\$")

    fun inputRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = readln().trim()
        checkIsNumber(input)
        return input.toInt()
    }

    fun checkIsNumber(input: String) {
        if (!numberRegex.matches(input)) {
            throw IllegalArgumentException("잘못된 입력")
        }
    }

    fun inputCarNames(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = readln().trim()

        return afterCheckConvertCarList(input)
    }

    fun afterCheckConvertCarList(input: String): List<Car> {
        checkContainRestPoint(input)
        checkUnderFiveCharRegex(input)
        return convertInputToCarList(input)
    }

    private fun convertInputToCarList(input: String): List<Car> {
        return restPointRegex.findAll(input).map { Car(it.value) }.toList()
    }

    private fun checkUnderFiveCharRegex(input: String) {
        val cars = restPointRegex.findAll(input)
        for (car in cars) {
            println(car.value)
            if (!underFiveCharRegex.matches(car.value)) {
                throw IllegalArgumentException("잘못된 입력")
            }
        }
    }

    private fun checkContainRestPoint(input: String) {
        when(true){
            ("," !in input)->{
                throw IllegalArgumentException("자동차 개수 0 또는 1개 입력")
            }
            (input[0] == ',')->{
                throw IllegalArgumentException("맨앞 쉼표")
            }
            (input[input.length - 1] == ',') ->{
                throw IllegalArgumentException("맨뒤 쉼표")
            }
            (",," in input)->{
                throw IllegalArgumentException("자동차 이름 공백")
            }
            else -> {}
        }
    }

    fun printCarStatus(carList: List<Car>) {
        carList.forEach { car ->
            println("${car.name} : ${"-".repeat(car.runCount)}")
        }
        println()
    }

    fun printResultMessage() {
        println("실행결과")
    }

    fun printResult(carList: List<Car>) {
        val maxCount = carList.maxBy { car -> car.runCount }.runCount
        val maxCarList = carList.filter { car -> car.runCount == maxCount }.map { car -> car.name }
        println("최종 우승자 : ${maxCarList.joinToString(", ")}")
    }


}