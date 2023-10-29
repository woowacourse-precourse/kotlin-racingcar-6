//package racingcar
//import camp.nextstep.edu.missionutils.Randoms
//import camp.nextstep.edu.missionutils.Console.readLine
//
//fun main() {
//    println("경주할 자동차 이름을 입력하세요.")
//    val carNames = readLine().split(',').map { it.trim() } // 쉼표로 나눈 후 앞뒤 공백 제거
//    val carNamesAndResults = mutableMapOf<String, String>()
//    val winners = mutableListOf<String>()
//    var longDistance = ""
//
//    for (i in carNames) {
//        i.trim() // 앞뒤 공백 제거
//        if (i == "" || i.length > 5)
//            throw IllegalArgumentException("모든 자동차 이름은 1글자 이상, 5글자 이하여야 합니다.")
//        if (i in carNamesAndResults.keys)
//            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
//        carNamesAndResults[i] = ""
//    }
//
//    println("시도할 횟수는 몇 회인가요?")
//    val timeInput = readLine()
//    println("\n실행 결과")
//    val time: Int = try {
//        timeInput?.toInt() ?: throw IllegalArgumentException("유효한 숫자를 입력하세요.")
//    } catch (e: NumberFormatException) {
//        throw IllegalArgumentException("유효한 숫자를 입력하세요.")
//    }
//    if (time < 1)
//        throw IllegalArgumentException("0보다 큰 숫자를 입력하세요.")
//
//    for (i in 0 until time) {
//        for (j in carNames) {
//            val num = Randoms.pickNumberInRange(0, 9)
//            //print(num)
//            if (num >= 4)
//                carNamesAndResults[j] += "-"
//            println(j + " : " + carNamesAndResults[j])
//        }
//        println()
//    }
//
//    longDistance = carNamesAndResults.maxBy { it.value }.value
//
//    for (i in carNamesAndResults) {
//        if (i.value == longDistance)
//            winners.add(i.key)
//    }
//    println("최종 우승자 : " + winners.joinToString(", "))
//}


package racingcar
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val carNames = getCarNames()
    val carNamesAndResults = raceCars(carNames)
    val winners = findWinners(carNamesAndResults)
    printResults(winners)
}

fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.")
    val carNamesInput = readLine()
    val carNames = carNamesInput.split(',').map { it.trim() } // 쉼표로 나눈 후 앞뒤 공백 제거

    validateCarNames(carNames)

    return carNames
}

// 자동차 이름 예외 처리
fun validateCarNames(carNames: List<String>) {
    if (carNames.any { it.isEmpty() || it.length > 5 })
        throw IllegalArgumentException("모든 자동차 이름은 1글자 이상, 5글자 이하여야 합니다.")

    if (carNames.size != carNames.toSet().size)
        throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
}

fun raceCars(carNames: List<String>): Map<String, String> {
    val carNamesAndResults = mutableMapOf<String, String>()
    val time = getRaceTime()

    for (i in carNames) {
        carNamesAndResults[i] = "" // 전진 값 초기화
    }

    for (i in 0 until time) {
        for (j in carNames) {
            val num = Randoms.pickNumberInRange(0, 9)
            if (num >= 4) {
                carNamesAndResults[j] += "-" // 4 이상의 수가 나오면 전진
            }
            println("$j : ${carNamesAndResults[j]}")
        }
        println()
    }

    return carNamesAndResults
}

// 시도 횟수 결정
fun getRaceTime(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val timeInput = readLine()
    val time = timeInput?.toInt() ?: throw IllegalArgumentException("유효한 숫자를 입력하세요.")

    if (time < 1)
        throw IllegalArgumentException("0보다 큰 숫자를 입력하세요.")

    return time
}

// 우승 자동차 찾기
fun findWinners(carNamesAndResults: Map<String, String>): List<String> {
    val longDistance = carNamesAndResults.maxBy { it.value }?.value ?: ""
    return carNamesAndResults.filter { it.value == longDistance }.keys.toList() // 가장 많이 전진한 자동차들 이름 반환
}

// 우승자 출력
fun printResults(winners: List<String>) {
    println("최종 우승자 : ${winners.joinToString(", ")}")
}
