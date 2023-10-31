package racingcar

import racingcar.domain.User

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val result = User.resultName
    println("시도할 횟수는 몇 회인가요?")
    val num = User.tryNum
}
