package racingcar

import camp.nextstep.edu.missionutils.Console

class CarGame {
    private var carNames = listOf<String>()
    var cars = mutableListOf<Car>()
    private var count = 0
    fun startGame() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        carNames = Console.readLine()?.split(",") ?: emptyList()

        if (carNames.isEmpty() || !carNames.all { it.length <= 5 }) {
            throw IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.")
        } else {
            makeCar()
        }

        getNumber()

        println("실행 결과")

        while (count > 0) {
            race()
            count--
        }

        winner()
    }

    fun getNumber() {
        println("시도할 횟수는 몇 회인가요?")
        count = Console.readLine().toIntOrNull() ?: throw java.lang.IllegalArgumentException("숫자만 입력하세요")
    }

    private fun makeCar() {
        for (carName in carNames) {
            cars.add(Car(carName))
        }
    }

    private fun race() {
        for (car in cars) {
            car.generateRanNum()
        }

        for (car in cars) {
            car.printPosition()
        }
        println()
    }

    fun winner() {
        val maxPosition = cars.maxByOrNull { it.getPosition() }?.getPosition()
        val winners = cars.filter { it.getPosition() == maxPosition }.map { it.getCarName() }

        if (winners.isNotEmpty()) {
            val winnersString = winners.joinToString(", ")
            println("최종 우승자 : $winnersString")
        }
    }
}