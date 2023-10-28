package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car

fun main() {
    var carNames: MutableList<Car> = mutableListOf()
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    carNames = askCarName(carNames, Console.readLine())
    println("시도할 횟수는 몇 회인가요?")
    val count = askNumber(Console.readLine())
    var highScore = 0
    for (i in 1..count) {
        carNames.all {
            it.move()
            it.printResult()
            if (it.getDistance() > highScore)
                highScore = it.getDistance()
            true
        }
    }
    printWinner(carNames, highScore)
}

fun askCarName(carNames: MutableList<Car>, input: String): MutableList<Car> {
    val carNameList = input.split(",")
    for (carName in carNameList) {
        if (carName.length > 5)
            throw IllegalArgumentException("String index out of range: 5")
        carNames.add(Car(carName))
    }
    return carNames
}

fun askNumber(count: String): Int {
    return count.toIntOrNull() ?: throw IllegalArgumentException("Input is not Int")
}

fun printWinner(carNames: MutableList<Car>, highScore: Int) {
    var isFirst = true
    print("최종 우승자 : ")
    carNames.all {
        isFirst = decideWinner(it,highScore,isFirst)
        true
    }
    println()
}

fun decideWinner(car:Car,highScore:Int,isFirst:Boolean):Boolean{
    if(car.getDistance()==highScore){
        val name = car.getName()
        if (isFirst) {
            print(name)
            return false
        }
        print(", $name")
        return false
    }
    return isFirst
}
