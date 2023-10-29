package racingcar

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printGameStartMessage()
    gameStart()
}

fun gameStart() {
    val nameList = separateCarNames(inputCarNames())
    validateNameLength(nameList)
    val carModelList = makeCarModelList(nameList)
    println("시도할 횟수는 몇 회인가요?")
    val count = inputRaceCount()

    println("실행결과")
    repeat(count) {
        carModelList.forEachIndexed { index, name ->
            var moveOrNot = moveOrStop()
            if (moveOrNot) {
                carModelList[index].moveOneStep()
            }
            printName(carModelList[index].name)
            printDistance(carModelList[index].moveDistance)
        }
        println()
    }
    val winnerList = getWinner(carModelList)
    printWinner(winnerList)
}

fun printGameStartMessage() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
}

fun inputCarNames(): String {
    return Console.readLine()
}

fun separateCarNames(carNames: String): List<String> {
    return carNames.split(",")
}

fun makeCarModelList(carNames: List<String>): MutableList<Car> {
    var modelList = mutableListOf<Car>()
    carNames.forEach {
        modelList.add(Car(it))
    }

    return modelList
}

fun validateNameLength(carList: List<String>) {
    carList.forEach {
        if (it.length > 5) throw IllegalArgumentException("차 이름의 길이가 5보다 큽니다.")
    }
}

fun validateNull(carList: List<String>) {
    carList.forEach {
        if (it.trim().isEmpty()) throw IllegalArgumentException("차 이름의 길이가 5보다 큽니다.")
    }
}

fun inputRaceCount(): Int {
    val input = Console.readLine()
    validateNumber(input)

    return input.toInt()
}

fun validateNumber(count: String) {
    count.toIntOrNull() ?: throw IllegalArgumentException("사용자의 입력이 숫자가 아닙니다.")
}

fun getRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

fun moveOrStop(): Boolean {
    val getNumber = getRandomNumber()
    return getNumber >= 4
}

fun printName(name: String) {
    print("$name : ")
}

fun printDistance(distance: Int) {
    repeat(distance) {
        print("-")
    }
    println()
}

//굳이 두개로 나눠야할까?
fun getWinner(carModelList: List<Car>): MutableList<String> {
    val nameList = carModelList.map { it.name }
    val distanceList = carModelList.map { it.moveDistance }

    return findWinner(nameList, distanceList)
}

fun findWinner(nameList: List<String>, distanceList: List<Int>): MutableList<String> {
    var winnerList = mutableListOf<String>()
    val maxDistance = distanceList.max()

    for (i in distanceList.indices) {
        if (distanceList[i] == maxDistance) {
            winnerList.add(nameList[i])
        }
    }

    return winnerList
}

fun printWinner(winnerList: MutableList<String>) {
    val winner = winnerList.joinToString(", ")
    println("최종 우승자 : $winner")
}