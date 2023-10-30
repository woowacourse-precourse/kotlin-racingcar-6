package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
fun main() {
    // TODO: 프로그램 구현

}


fun generateCars(): List<String> {
    println(INPUT_CAR_NAMES)
    val carNames = Console.readLine().split(",").map { it.trim() }

    return carNames
}




