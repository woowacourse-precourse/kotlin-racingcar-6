package race

import camp.nextstep.edu.missionutils.Console
import constant.Constant
import constant.ErrorString
import kotlin.IllegalArgumentException

class CarController(private val carModel: CarModel, private val printResult: PrintResult) {
    fun runRace() {
        printResult.printMessage(Constant.CAR_INPUT_STRING)
        val carString = inputString()
        validateCarInput(carString)
        processCarInput(carString)
        printResult.printMessage(Constant.TRY_NUMBER_INPUT_STRING)
        val moveNum = inputMoveNum()
        println()
        carModel.moveCars(moveNum)
        printWinner()
    }

    private fun inputString(): String {
        return Console.readLine()
    }

    private fun validateCarInput(carString: String) {
        if (carString.isEmpty()) {
            throw IllegalArgumentException(ErrorString.NO_INPUT_ERROR)
        } else if (carString.contains(",,") || carString.startsWith(',') || carString.endsWith(',')) {
            throw IllegalArgumentException(ErrorString.INPUT_VALUE_ERROR)
        }
    }

    private fun processCarInput(carString: String) {
        val cars = carString.split(',')
        for (car in cars) {
            if (car.trim().isEmpty() || car.contains(" ")) {
                throw IllegalArgumentException(ErrorString.INPUT_VALUE_ERROR)
            } else if (car.length > Constant.CAR_NAME_MAX_LENGTH) {
                throw IllegalArgumentException(ErrorString.INPUT_LENGTH_ERROR)
            } else {
                if (carModel.checkCar(car)) {
                    throw IllegalArgumentException(ErrorString.INPUT_REPEAT_ERROR)
                }
                carModel.addCar(car)
            }
        }
    }

    private fun inputMoveNum(): Int {
        val moveNumber = inputString()
        return checkMoveNum(moveNumber)
    }

    private fun checkMoveNum(inputNumber: String): Int {
        if (inputNumber.isEmpty()) {
            throw IllegalArgumentException(ErrorString.NO_INPUT_ERROR)
        } else if (isInteger(inputNumber)) {
            return inputNumber.toInt()
        } else {
            throw IllegalArgumentException(ErrorString.INTEGER_INPUT_ERROR)
        }
    }

    private fun isInteger(checkString: String): Boolean {
        return try {
            checkString.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun printWinner() {
        val winners = carModel.getWinners()
        if (winners.size == 1) {
            printResult.printMessage(Constant.WINNER_STRING + winners[0])
        } else {
            val result = winners.joinToString(", ")
            printResult.printMessage(Constant.WINNER_STRING + result)
        }
    }
}