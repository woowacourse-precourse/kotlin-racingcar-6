package view

import camp.nextstep.edu.missionutils.Console
import service.ExceptionHandler

class InputView {
    fun requireCarNames(): List<String> {
        val carNames = Console.readLine()
        ExceptionHandler.checkNames(carNames)
        val names = carNames.split(",")
        isValidLength(names)
        return names
    }

    fun isValidLength(names: List<String>) {
        for (name in names) {
            ExceptionHandler.checkNameLength(name)
        }
    }
    fun requireTryCnt(): Int {
        var cnt : String
        do {
            cnt = Console.readLine()
        } while (!ExceptionHandler.checkValidCount(cnt))
        return cnt.toInt()
    }
}