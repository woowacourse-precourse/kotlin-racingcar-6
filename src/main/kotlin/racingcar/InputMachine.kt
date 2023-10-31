package racingcar

class InputMachine {

    // 자동차 이름 입력↓
    fun makeCars(): List<String> {

        val cars = readln().split(",")

        checkCarNameUnder5(cars)

        return cars

    }

    private fun checkCarNameUnder5(cars: List<String>) {

        for (car in cars) {

            if (car.length > 5) {

                throw IllegalArgumentException("자동차 이름이 5자를 초과합니다.")

            }
        }
    }
    //

    // 몇 번 이동 입력↓
    fun tryMove(): Int {

        val tryCount: Int

        try {
            tryCount = readln().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자를 입력하세요")
        }

        if (!checkOnlyNatural(tryCount)) {
            throw IllegalArgumentException("양의 정수를 입력하세요")
        }
        println()

        return tryCount

    }

    private fun checkOnlyNatural(move: Int): Boolean {

        return move > 0

    }

}