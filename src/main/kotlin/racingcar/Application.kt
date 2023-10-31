package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val input = getCarsName()
    val cars = generateCarsFromInput(input)

    val turn = getTurnNumber()
}

fun getTurnNumber(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return try {
        Console.readLine().toInt()
    } catch (e: NumberFormatException) {
        e.printStackTrace()
        GameUtils.onWrongInput()
    }
}

fun generateCarsFromInput(input: String): List<Car> {
    val tokens = input.split(",")
    val cars = tokens.map { token ->
        generateCarFromToken(token)
    }
    return cars
}

fun generateCarFromToken(token: String): Car {
    GameUtils.checkValidInput {
        token.length <= 5
    }
    return Car(token)
}

fun getCarsName(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    GameUtils.checkValidInput { input != null }
    return input
}