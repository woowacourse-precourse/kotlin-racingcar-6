package racingcar

import camp.nextstep.edu.missionutils.Console

class Game {
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputString = Console.readLine()
        val names = inputString.split(",").map { it.trim() }
        val cars: List<Car> = names.map { Car(it) }
        println("시도할 횟수는 몇 회인가요?")
        val loopCount = Console.readLine().trim().toLegalInt()
        println("실행 결과")
        cars.race(loopCount)
        print("최종 우승자 : ")
        println(cars.winner())
    }
}

fun String.toLegalInt(): Int {
    try {
        return this.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자만 입력하세요.")
    }
}

