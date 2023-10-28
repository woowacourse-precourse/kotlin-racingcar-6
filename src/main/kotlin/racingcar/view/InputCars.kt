package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputCars {
    operator fun invoke(str: String = Console.readLine()): List<String> {
        return str.split(',').map { it.trim() }
    }
}