package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val racingCarGame = RacingCarGame()
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
        for (car in cars){
            if (racingCarGame.isRandomNumberMet()) car.moveForward()
            car.printPresentDistance()
        }
        println()
    }

    for (car in cars){
        if (car.getDistance() == racingCarGame.getWinningDistance()) {
            racingCarGame.addWinner(car.getName())
        }
        if (car.getDistance() > racingCarGame.getWinningDistance()) {
            racingCarGame.changeWinner(car.getName(), car.getDistance())
        }
    }

    println("최종 우승자 : ${racingCarGame.getWinnersListAsString()}")
    Console.close()

}
