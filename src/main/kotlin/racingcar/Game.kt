package racingcar

import camp.nextstep.edu.missionutils.Console


class Game {

    fun playGame() {
        doingGame()
    }

    private fun createCars(): List<Car> {
        val carList = Driver().inputCarName()
        return carList.map { Car(it) }
    }

    private fun doingGame() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carList = createCars()
        println("시도할 횟수는 몇 회인가요?")
        val tryGame = Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요")
        val maxDistance = CarFactory().displyCarRace(carList, tryGame)
        val winners = findWinner(carList, maxDistance)
        println("최종 우승자 : $winners")
    }

    private fun findWinner(cars: List<Car>, maxDistance: Int): String {
        return cars.filter { it.distance == maxDistance }.joinToString(", ") { it.name }
    }
}