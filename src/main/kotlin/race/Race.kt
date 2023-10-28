package race

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException
import constant.ErrorString
import constant.Constant

class Race {
    public val garage = mutableMapOf<String, Int>()

    companion object {
        fun run() {
            val race = Race()
            race.inputCar()
            val moveNum = race.inputMoveNum()
            race.carMove(moveNum)
            race.printWinner()
        }
    }

    fun inputCar() {
        println(Constant.CAR_INPUT_STRING)
        val carString = Console.readLine()
        checkCar(carString)

    }

    private fun checkCar(carString:String) {
        if (carString.isEmpty()) {
            throw IllegalArgumentException(ErrorString.NO_INPUT_ERROR)
        } else if (carString.contains(",,") || carString.startsWith(',') || carString.endsWith(',')) {
            throw IllegalArgumentException(ErrorString.INPUT_VALUE_ERROR)
        }
        val cars = carString.split(',')
        for (car in cars) {
            if (car.trim().isEmpty() || car.contains(" ")) {
                throw IllegalArgumentException(ErrorString.INPUT_VALUE_ERROR)
            } else if (car.length > Constant.CAR_NAME_MAX_LENGTH) {
                throw IllegalArgumentException(ErrorString.INPUT_LENGTH_ERROR)
            } else {
                if (garage.keys.contains(car)) {
                    throw IllegalArgumentException(ErrorString.INPUT_REPEAT_ERROR)
                }
                garage[car] = 0
            }
        }
    }

    fun inputMoveNum(): Int {
        println(Constant.TRY_NUMBER_INPUT_STRING)
        val moveNumber = Console.readLine()
        if (isInteger(moveNumber)) {
            return moveNumber.toInt()
        } else {
            throw IllegalArgumentException(ErrorString.INTEGER_INPUT_ERROR)
        }
    }

    private fun isInteger(checkString: String): Boolean {
        return try {
            checkString.toInt()
            true
        } catch (e: NumberFormatException) {
            println(ErrorString.INTEGER_INPUT_ERROR)
            false
        }
    }

    fun carMove(moveNum: Int) {
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

    private fun checkMove(): Boolean {
        val randomNumber = generateRandomNum()
        return randomNumber >= Constant.MOVE_BASE_NUMBER
    }

    private fun generateRandomNum(): Int {
        val ranNum = Randoms.pickNumberInRange(Constant.RANDOM_START_NUMBER, Constant.RANDOM_END_NUMBER)
        print(ranNum) // 결과 확인용
        return ranNum
    }

    private fun printMove(car: String, count: Int) {
        val repeatMinus = "-".repeat(count)
        println("$car : $repeatMinus")
    }

    private fun getWinner(garage: Map<String, Int>): List<String> {
        val maxValue = garage.values.max()
        val winner = mutableListOf<String>()
        for ((car, value) in garage.entries) {
            if (value == maxValue) {
                winner.add(car)
            }
        }
        return winner
    }

    fun printWinner() {
        val winner = getWinner(garage)
        if (winner.size == 1) {
            print(Constant.WINNER_STRING + winner[0])
        } else {
            val result = winner.joinToString(", ")
            print(Constant.WINNER_STRING + result)
        }
    }
}