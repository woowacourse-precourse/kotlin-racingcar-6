package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine()

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = Console.readLine().toIntOrNull()

    println("\n실행 결과")

    require(carNames != null && tryCount != null && tryCount > 0) { throw IllegalArgumentException("잘못된 입력입니다.")}

    val carNameList = carNames.split(",")

}

