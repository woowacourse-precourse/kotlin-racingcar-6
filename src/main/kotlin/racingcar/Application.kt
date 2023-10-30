package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)")
    val carNames = Console.readLine()
    if (carNames.length > 5){
        throw IllegalArgumentException("5글자 이하로 이름을 지어주세요")
    }
    val cars = carNames.split(',').map { Cars(it) }

    println("시도할 횟수는 몇 회인가요?")
    val winPoint = Console.readLine().toInt()
    if (winPoint <= 0){
        throw IllegalArgumentException("자연수로 입력해주세요")
    }
    while (cars.none { it.position >= winPoint }){
        cars.forEach { car->
            car.move()
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    //만약 car.position == winPoint 일때
    //그 car에 대해서 car.name이 출력
    val winner = mutableListOf<String>()
    for (car in cars) {
        if (car.position == winPoint){
            winner.add(car.name)
        }
    }
    print("최종 우승자 : ${winner.joinToString(separator = ", ")}")
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

