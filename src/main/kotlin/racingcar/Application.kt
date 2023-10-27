package racingcar
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.")
    val carNames = readLine().split(',').map { it.trim() } // 쉼표로 나눈 후 앞뒤 공백 제거
    val carNamesAndResults = mutableMapOf<String, String>()
    val winners = mutableListOf<String>()
    var longDistance = ""

    // 추가할 기능: 자동차 이름 공백 제거, 중복된 자동차 이름 처리
    for (i in carNames) {
        i.trim()
        if (i == "" || i.length > 5)
            throw IllegalArgumentException("모든 자동차 이름은 1글자 이상, 5글자 이하여야 합니다.")
        if (i in carNamesAndResults.keys)
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
        carNamesAndResults[i] = ""
    }

    println("시도할 횟수는 몇 회인가요?")
    val timeInput = readLine()
    println("\n실행 결과")
    val time: Int = try {
        timeInput?.toInt() ?: throw IllegalArgumentException("유효한 숫자를 입력하세요.")
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("유효한 숫자를 입력하세요.")
    }
    if (time < 1)
        throw IllegalArgumentException("0보다 큰 숫자를 입력하세요.")

    for (i in 0 until time) {
        for (j in carNames) {
            val num = Randoms.pickNumberInRange(0, 9)
            //print(num)
            if (num >= 4)
                carNamesAndResults[j] += "-"
            println(j + " : " + carNamesAndResults[j])
        }
        println()
    }

    longDistance = carNamesAndResults.maxBy { it.value }.value

    for (i in carNamesAndResults) {
        if (i.value == longDistance)
            winners.add(i.key)
    }
    println("최종 우승자 : " + winners.joinToString(", "))
}
