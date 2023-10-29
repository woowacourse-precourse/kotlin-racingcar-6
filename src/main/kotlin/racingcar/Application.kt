package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)")
    val carNames = Console.readLine()

    println(carNames.split(','))

    val cars = carNames.split(',').map { Cars(it) }

    cars.forEach { car ->
        println("${car.name} : ${car.position}")
    }

}

class Cars(carName: String) {
    val position = 0
    val name = carName
}