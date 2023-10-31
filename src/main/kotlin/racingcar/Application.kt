package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carInput = Console.readLine()
    val carList = carInput.split(",")
    processExceptionCar(carInput, carList)

    val playCount= Console.readLine()
    processExceptionCount(playCount)
}

fun processExceptionCar(carInput: String, carList: List<String>) {
    if (carInput.isNullOrBlank()) {
        throw IllegalArgumentException(Const.EXCEPTION_WRONG_INPUT)
    }
    for (name in carList) {
        if (name.toList().any { !it.isLetterOrDigit() }) {
            throw IllegalArgumentException(Const.EXCEPTION_WRONG_NAME)
        }

        if (name.length > 5) {
            throw  IllegalArgumentException(Const.EXCEPTION_NAME_LENGTH)
        }
    }
}

fun processExceptionCount(playCount: String) {
    if (playCount.isNullOrBlank() || playCount == "0") {
        throw IllegalArgumentException(Const.EXCEPTION_WRONG_NUMBER)
    }
    if (playCount.toList().any { !it.isDigit() }) {
        throw IllegalArgumentException(Const.EXCEPTION_NOT_NUMBER)
    }
}
