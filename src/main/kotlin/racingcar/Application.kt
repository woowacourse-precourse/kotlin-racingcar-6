package racingcar

import camp.nextstep.edu.missionutils.Console


fun main(arge: Array<String>) {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val car = Console.readLine()!!.split(",")
    val cars = car.map { Car() }

    println("시도할 횟수는 몇 회인가요?")
    val rounds = Console.readLine()!!.toInt()

    val race = Race(cars, rounds)
    race.run()
}

class Car {

}

class Race {

}