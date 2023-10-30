package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStart()
}

class Car {
    var name: String = ""
    var movementCount: Int = 0
}

class GameStatus {
    var listOfCar = mutableListOf<Car>()
    var countOfTrial: Int = 0
}

fun gameStart() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputNames = Console.readLine()
    val listOfCarName = checkValidName(inputNames)

    println("시도할 횟수는 몇 회인가요?")
    val inputCount = Console.readLine()
    val countOfTrial = checkValidNumber(inputCount)

    startRace(listOfCarName, countOfTrial)
}

fun startRace(listOfCarName: List<String>, count: Int) {
    var carMovementCount = mutableListOf<Int>()
    println("실행 결과")
    for (i in 0..count) {
        carMovementCount += selectRandomNumber(listOfCarName)
    }
}

fun selectRandomNumber(listOfCarName: List<String>): List<Int> {
    var isCarMoved = mutableListOf<Int>(listOfCarName.size)
    for (i in 0..listOfCarName.size) {
        val randomNumber = Randoms.pickNumberInRange(0,9)
        if (randomNumber >= 4) {
            isCarMoved[i]++
        }
    }
    return isCarMoved
}

fun checkValidName(stringOfNames: String): List<String> {
    val listOfCarName = stringOfNames.split(",")
    for (name in listOfCarName) {
        if (name.length > 5)
            throw IllegalArgumentException("5자 이상인 이름 입력 발생")
    }
    return listOfCarName
}

fun checkValidNumber(countString: String): Int {
    if (countString.toIntOrNull() == null) {
        throw IllegalArgumentException("숫자가 아닌 횟수 입력 발생")
    }
    return countString.toInt()
}