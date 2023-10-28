package racingcar

import User.User

fun main() {
    // TODO: 프로그램 구현
    val user = User()
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    user.inputCarName()
}
