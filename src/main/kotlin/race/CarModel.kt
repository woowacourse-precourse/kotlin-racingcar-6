package race

import camp.nextstep.edu.missionutils.Randoms
import constant.Constant

class CarModel {
    val garage = mutableMapOf<String, Int>()

    fun addCar(name: String) {
        garage[name] = 0
    }

    fun moveCars(moveNum: Int) {
        println(Constant.RESULT_STRING)
        for (i in 0..<moveNum) {
            carMoveOnce()
        }
    }

    private fun carMoveOnce() {
        for ((car, moveCount) in garage.entries) {
            if (checkMove()) {
                garage[car] = moveCount + 1
                printMove(car, moveCount + 1)
            } else {
                printMove(car, moveCount)
            }
        }
        println()
    }

    private fun printMove(message: String, count: Int) {
        val repeatMinus = "-".repeat(count)
        println("$message : $repeatMinus")
    }


    private fun checkMove(): Boolean {
        val randomNumber = generateRandomNum()
        return randomNumber >= Constant.MOVE_BASE_NUMBER
    }

    private fun generateRandomNum(): Int {
        //print(ranNum) 결과 확인용
        return Randoms.pickNumberInRange(Constant.RANDOM_START_NUMBER, Constant.RANDOM_END_NUMBER)
    }

    fun checkGarageSize() {
        if (garage.size !in Constant.MIN_CAR_NUMBER..Constant.MAX_CAR_NUMBER)
            throw IllegalArgumentException("두 대 이상의 자동차가 있어야 합니다.")

    }

    fun getWinners(): List<String> {
        val winner = mutableListOf<String>()
        val maxValue = garage.values.max()
        for ((car, value) in garage.entries) {
            if (value == maxValue) {
                winner.add(car)
            }
        }
        return winner
    }
}