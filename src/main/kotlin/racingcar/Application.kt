package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carInput = Console.readLine()
    val carList = carInput.split(",")
    processExceptionCar(carInput, carList)

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
