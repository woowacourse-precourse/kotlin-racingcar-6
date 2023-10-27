package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun splitCarName(initCarName: String): List<String> {
    return initCarName.split(",")
}

fun enterCarName(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val initCarName = Console.readLine()

    return splitCarName(initCarName)
}

fun main() {
    enterCarName()
}
