package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carNames = readCarNames()//차이름
    val tryCount = readTryCount()//입력한 수

    raceCars(carNames, tryCount)
}

fun readCarNames(): List<String> {
    while (true) {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) ")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }


        //빈값 입력이거나, 2개 이상의 이름 받기,5글자 이하까지
        if (input == null) {
            throw IllegalArgumentException("입력이 없습니다.")
        } else if (carNames.any { it.isBlank() }) {
            throw IllegalArgumentException("이름을 공백으로 입력할 수 없습니다.")
        } else if (carNames.size < 2) {
            throw IllegalArgumentException("이름은 최소 2개 이상 입력 해야 합니다.")
        } else if (carNames.all { it.length <= 5 }) {
            return carNames
        } else {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }

    }
}

fun readTryCount(): Int {
    while (true) {
        println("시도할 회수는 몇 회 인가요?")
        val tryCount = Console.readLine()

        if (tryCount != null && tryCount.all { it.isDigit() }) {
            val tryCountInt = tryCount.toInt()
            if (tryCountInt > 0) {
                return tryCountInt
            }
        }
        //익셉션 처리하기
        println("올바른 숫자를 입력해주세요.")
    }
}

fun raceCars(carNames: List<String>, tryCount: Int) {
    println("\n시도 결과")

    val totalDistances = mutableMapOf<String, Int>()

    (1..tryCount).forEach { tryIndex ->
        println("\n$tryIndex 라운드")
        val distances = calculateDistances(carNames)

        distances.forEach { (name, distance) ->
            val currentDistance = totalDistances.getOrDefault(name, 0)
            totalDistances[name] = currentDistance + distance.count { it == '-' }
        }

        printDistances(totalDistances)
    }
    printWinner(totalDistances)
}

fun calculateDistances(carNames: List<String>): List<Pair<String, String>> {
    return carNames.map { carName ->
        val distance = (0 until 1).count {
            val randomValue = Randoms.pickNumberInRange(0,9)
            randomValue >= 4
        }
        carName to "-".repeat(distance)
    }
}

fun printDistances(totalDistances: Map<String, Int>) {
    totalDistances.forEach { (name, distance) ->
        println("$name : ${"-".repeat(distance)}")
    }
}

fun printWinner(totalDistances: Map<String, Int>) {
    val maxDistance = totalDistances.values.maxOrNull()
    val winners = totalDistances.filterValues { it == maxDistance }.keys

    if (winners.size == 1) {
        println("\n최종 우승자 : ${winners.first()}")
    } else {
        println("\n최종 우승자 : ${winners.joinToString(", ")}")
    }
}





