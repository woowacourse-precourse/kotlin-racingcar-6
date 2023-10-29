package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars: List<Car> = readLine()
        .split(",")
        .toCarListOrNull()

    println("시도할 횟수는 몇 회인가요?")
    val rounds: Int = readLine().toIntOrNull() ?: throw IllegalArgumentException()

    println("\n실행 결과")
    repeat(rounds){
        startRound(cars)
        printRoundResult(cars)
    }

    print("최종 우승자 : ")
    val winners = findWinner(cars).joinToString(", ") { car -> car.name }
    println(winners)

}

fun List<String>.toCarListOrNull(): List<Car>{
    return this.map {name ->
        if(name.length > 5) throw IllegalArgumentException()
        if(name == "") throw IllegalArgumentException()

        Car(name)
    }
}

fun startRound(cars: List<Car>) {
    cars.forEach {
        it.moveForward()
    }
}

fun printRoundResult(cars: List<Car>){
    cars.forEach {
        println(it)
    }
    println()
}

fun findWinner(cars: List<Car>): List<Car>{
    val maxForward = cars.maxByOrNull { it.forward }?.forward
    return cars.filter { it.forward == maxForward }
}
