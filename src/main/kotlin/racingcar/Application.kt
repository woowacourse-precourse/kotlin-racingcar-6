package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine().split(',')
    println("$carNames")

    carNamesValidator(carNames)

    println("시도할 횟수는 몇 회인가요?")
    val tryNum = Console.readLine().toInt()
    println("$tryNum")

    tryNumValidator(tryNum)

    val cars = createCars(carNames)

    for(i in 1..tryNum){
        println("실행결과")
        tryOne(cars)
    }
}

fun tryOne(cars: List<Car>){
    for(car in cars){
        val randomNum = generateNum()
        if(randomNum >= 4) car.movingFoward()
    }
    for(car in cars){
        println("${car.name} : "+"-".repeat(car.distance))
    }
    println()
}

fun createCars(carNames: List<String>): List<Car> {
    val cars = mutableListOf<Car>()

    for (name in carNames) {
        val car = Car(name)
        cars.add(car)
    }

    return cars
}

fun generateNum(): Int {
    val randomNumber = Randoms.pickNumberInRange(0, 9)

    return randomNumber
}

class Car(name: String) {
    val name: String = name
    var distance = 0

    fun movingFoward() {
        distance++
    }
}

fun carNamesValidator(carNames: List<String>) {
    for (car in carNames) {
        if (car.length > 5) throw IllegalArgumentException("이름은 5자 이하만 가능합니다")
    }
}

fun tryNumValidator(tryNum: Int) {
    if (tryNum <= 0) throw IllegalArgumentException("시도 횟수는 자연수만 가능합니다")
}