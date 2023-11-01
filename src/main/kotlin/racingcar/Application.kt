package racingcar

import camp.nextstep.edu.missionutils.Console
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal

fun main() {
    getValidCarNamesArray(getCarNames())
}

fun getCarNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine()
}

fun getValidCarNamesArray(carNames: String): Collection<String> {
    val carNamesArray = carNames.split(",")
    if (carNamesArray.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자 이하 이어야 함")
    }
    return carNamesArray
}

