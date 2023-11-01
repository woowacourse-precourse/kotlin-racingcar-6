package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {

}

fun getCarNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine()
}

fun validateCarNames(carNames: String): Boolean{
    val carNameArray = carNames.split(",")
    return !carNameArray.any{it.length>5}
}
