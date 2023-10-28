package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val getNames = Console.readLine().split(",")
    println("시도할 횟수는 몇 회인가요?")
    val peopleNum = getNames.size
    var trialCount = 0
    try {
        trialCount = Console.readLine().toInt()
    }
    catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }

    val cars = mutableListOf<CarModel>()
    for (name in getNames) {
        if (name.length > 5) throw IllegalArgumentException()
        cars.add(CarModel(name))
    }

    println("\n실행 결과")
    repeat(trialCount) {
//        for (name in cars.keys) {
        for (car in cars){
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.moveForward()
            }
            car.printPresentDistance()
        }
        println()
    }

    var winner = mutableListOf<String>()
    var winnerScore: Int = 0
    for (car in cars){
        if (car.getDistance() == winnerScore) {
            winner.add(car.getName())
        }
        if (car.getDistance() > winnerScore) {
            winnerScore = car.getDistance()
            winner = mutableListOf<String>()
            winner.add(car.getName())
        }
    }

    println("최종 우승자 : ${winner.joinToString(", ")}")
    Console.close()

}
