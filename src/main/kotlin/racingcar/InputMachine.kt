package racingcar

class InputMachine {

    // 자동차 이름 입력↓
    fun makeCars(): List<String> {

        val cars = readln().split(",")

        return cars

    }

    fun checkCarNameUnder5(cars: List<String>): Boolean {

        for (car in cars) {

            if (car.length > 5) {

                return false

            }
        }

        return true

    }
    //

    // 몇 번 이동 입력↓
    fun tryMove(): Int {

        val tryCount: Int

        try {

            tryCount = readln().toInt()

        } catch (e: NumberFormatException) {

            return -1

        }

        if (!checkOnlyNatural(tryCount)) {

            return -2

        }

        return tryCount

    }

    private fun checkOnlyNatural(move: Int): Boolean {

        return move > 0

    }

}