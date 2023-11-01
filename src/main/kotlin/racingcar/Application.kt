package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    inputCarNamesAndTrialNumber()
}

fun inputCarNamesAndTrialNumber() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNameAndTrialNumber = Console.readLine().split(",").toMutableList()
    println("시도할 횟수는 몇 회인가요?")
    carNameAndTrialNumber.add(Console.readLine())
    startRacing(carNameAndTrialNumber)
}

fun startRacing(carNameAndTrialNumber: MutableList<String>) {
    val forwardCount = MutableList(carNameAndTrialNumber.size - 1) { "" }
    println("\n실행 결과")
    for (i in 0 until carNameAndTrialNumber.last().toInt()){
        forwardCount.forEachIndexed { index, value ->
            if (makeRandomNumber()) {
                forwardCount[index] = "$value-"
            }
        }
        for (i in 0 until carNameAndTrialNumber.size - 1) {
            println("${carNameAndTrialNumber[i]} : ${forwardCount[i]} ")
        }
        println()
    }
    val resultIndex = getResult(forwardCount)
    print("최종 우승자 : ")
    for (element in resultIndex) {
        print("${carNameAndTrialNumber[element]},")

    }
}

fun makeRandomNumber(): Boolean {
    return Randoms.pickNumberInRange(0, 9) > 3
}

fun getResult(forwordCount: MutableList<String>): MutableSet<Int> {
    val result = mutableSetOf<Int>()
    for (i in 0 until forwordCount.size - 1) {
        if (forwordCount[0].length < forwordCount[i+1].length) {
            result.add(i+1)
        } else if (forwordCount[0].length == forwordCount[i+1].length) {
            result.clear()
            result.add(0)
            result.add(i+1)
        } else if (forwordCount[0].length > forwordCount[i+1].length) {
            result.add(0)
        }
    }
    println(result)
    return result
}