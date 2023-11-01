package racingcar

import camp.nextstep.edu.missionutils.Console
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal

fun main() {

}

data class Car(
    val name: String,
    val score: Int
)

fun getCarNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine()
}

fun getValidCarNamesArray(carNames: String): Collection<Car> {
    val carNamesArray = carNames.split(",").map { Car(it,0) }
    if (carNamesArray.any { it.name.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자 이하 이어야 함")
    }
    return carNamesArray
}

fun getNumberOfRacing(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine().toInt()
}





