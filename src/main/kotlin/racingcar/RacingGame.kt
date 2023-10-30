package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame {

    fun gameStart() {
        val cars = initCar()
        val computer = Computer()
    }

    private fun initCar(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val name = readCarNames()
        name.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("5글자를 초과할 수 없습니다.")
            }
            if (it.isEmpty()) {
                throw IllegalArgumentException("이름이 비어있습니다.")
            }
        }
        return name.map { Car(it) }
    }

    private fun readCarNames(): List<String> {
        val input = Console.readLine()
        return input.split(",")
    }

    private fun readRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
        if (count < 0) throw IllegalArgumentException("0보다 작은 수는 입력할 수 없습니다.")
        return count
    }

    private fun playGames(car: List<Car>, roundCount: Int) {}
}