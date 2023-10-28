package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import java.lang.NumberFormatException

fun main() {
    val racingCarList = makeRacingCarList(getRacingCarName())

    for (tryNumber in 0 until getTryNumber()) {
        forwardOrStop(racingCarList)
        printResult(tryNumber, racingCarList)
    }

    printWinners(racingCarList)
}

// 기능 1. 자동차 이름 입력받기
fun getRacingCarName(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val racingCarNameInputList = Console.readLine()
    val racingCarNameList = racingCarNameInputList.split(",")

    checkRacingCarNameValidation(racingCarNameList)

    return racingCarNameList
}

// 기능 2. 자동차 이름 입력 값 유효성 검사하기
fun checkRacingCarNameValidation(checkList: List<String>) {
    val checkDuplicateList = mutableListOf<String>()

    for (check in checkList) {
        if (check.length > 5) {
            throw IllegalArgumentException("자동차 이름은 이름은 5자 이하만 가능하다.")
        }

        if (checkDuplicateList.contains(check)) {
            throw IllegalArgumentException("자동차 이름은 중복이 허용되지 않는다.")
        }

        if (check.isEmpty()) {
            throw IllegalArgumentException("쉼표(,) 뒤에 자동차 이름이 입력되지 않았다.")
        }

        if (check[0] == ' ') {
            throw IllegalArgumentException("자동차 이름의 첫글자는 공백이 아니다.")
        }

        checkDuplicateList.add(check)
    }

    if (checkList.size < 2) {
        throw IllegalArgumentException("자동차 이름은 2개 이상 입력받아야 한다.")
    }
}

// 기능 3. 자동차 리스트 만들기
fun makeRacingCarList(racingCarNameList: List<String>): List<RacingCar> {
    val racingCarList = mutableListOf<RacingCar>()
    for (name in racingCarNameList) {
        racingCarList.add(RacingCar(name))
    }

    return racingCarList
}

// 기능 4. 시도할 횟수 정하기
fun getTryNumber(): Int {
    println("시도할 횟수는 몇 회인가요?")

    val inputTryNumber = Console.readLine()

    checkTryNumberValidation(inputTryNumber)

    return inputTryNumber.toInt()
}

// 기능 5. 시도할 횟수 입력값 유효성 검사하기
fun checkTryNumberValidation(check: String) {
    try {
        val checkNumber = check.toInt()

        if (checkNumber < 1) {
            throw IllegalArgumentException("시도할 횟수는 1보다 커야한다.")
        }

    } catch (exception: NumberFormatException) {
        throw IllegalArgumentException("시도할 횟수는 숫자여야 한다.")
    }
}

// 기능 6. 무작위 값 구하기
fun getRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

// 기능 7. 전진, 정지 판단하기
fun forwardOrStop(racingCarList: List<RacingCar>) {
    for (racingCar in racingCarList) {
        if (getRandomNumber() >= 4) {
            racingCar.moveForward()
        }
    }
}

// 기능 8. 실행 결과 출력하기
fun printResult(tryNumber: Int, racingCarList: List<RacingCar>) {
    if (tryNumber == 0) {
        println("\n실행 결과")
    }

    for (racingCar in racingCarList) {
        racingCar.printStatus()
    }
    println()
}

// 기능 9. 우승자 안내하기
fun printWinners(racingCarList: List<RacingCar>) {
    var maxNumberOfMove = 0

    for (racingCar in racingCarList) {
        if (racingCar.numberOfMove > maxNumberOfMove) {
            maxNumberOfMove = racingCar.numberOfMove
        }
    }

    val winners = mutableListOf<String>()

    for (racingCar in racingCarList) {
        if (racingCar.numberOfMove == maxNumberOfMove) {
            winners.add(racingCar.name)
        }
    }

    println("최종 우승자 : ${winners.joinToString(", ")}")
}