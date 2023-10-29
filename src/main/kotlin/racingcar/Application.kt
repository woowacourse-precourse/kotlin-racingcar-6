package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)")
    val carNames = Console.readLine()
    val cars = carNames.split(',').map { Cars(it) }

    println("시도할 횟수는 몇 회인가요?")
    val winPoint = Console.readLine().toInt()
    while (cars.none { it.position >= winPoint }){
        cars.forEach { car->
            car.move()
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}

private fun inputCarNames() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)")
    val carNames = Console.readLine()
    val cars = carNames.split(',').map { Cars(it) }
}

class Cars(carName: String) {
    var position = 0
    val name = carName

    fun move(){
        if (Randoms.pickNumberInRange(0, 9)>=4){
            position++
        }
    }
}