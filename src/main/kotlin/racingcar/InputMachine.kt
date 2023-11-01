package racingcar

// 우선 남겨두고 오류뜨며 지워보는거로
import java.lang.NumberFormatException

class InputMachine {

    // 자동차 이름 입력↓
    fun makeCars(): List<String> {

        return readln().split(",")

    }

    fun checkCarNameUnder5(cars: MutableList<Car>) {

        for (car in cars) {
            if (car.name.length > 5) {
                println("실패")
                throw IllegalArgumentException("자동차 이름이 5자를 초과합니다.")
            }
        }
        println("통과")

    }

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


        return tryCount

    }

    private fun checkOnlyNatural(move: Int): Boolean {

        return move > 0

    }


}