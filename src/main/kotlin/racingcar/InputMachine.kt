package racingcar

import java.lang.NumberFormatException

class InputMachine {

    // 자동차 이름 입력↓
    fun makeCars(): List<String> {

        val cars = readln().split(",")


        return cars

    }

    fun checkCarNameUnder5(cars: MutableList<Car>){

        for (car in cars) {
            if (car.name.length > 5) {
                println("실패")
                throw IllegalArgumentException("자동차 이름이 5자를 초과합니다.")
            }
        }

        println("통과")

    }
    //

    // 몇 번 이동 입력↓
    fun tryMove() : Int {

        val tryCount : Int

        try {
            tryCount = readln().toInt()
        } catch (e : NumberFormatException) {
            throw IllegalArgumentException("숫자를 입력하세요")
        }

        return tryCount

    }

    fun checkOnlyNatural(move: Int) : Boolean {
        return true
    }

}