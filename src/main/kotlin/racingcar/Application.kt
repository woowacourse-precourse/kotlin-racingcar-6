package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars: List<Car> = readLine()
        .split(",")
        .toCarListOrNull()

    println("시도할 횟수는 몇 회인가요?")
    val rounds: Int = readLine().toIntOrNull() ?: throw IllegalArgumentException()
}

fun List<String>.toCarListOrNull(): List<Car>{
    return this.map {name ->
        if(name.length > 5) throw IllegalArgumentException()
        if(name == "") throw IllegalArgumentException()

        Car(name, 0)
    }
}
