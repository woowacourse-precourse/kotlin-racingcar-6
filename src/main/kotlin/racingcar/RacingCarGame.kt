package racingcar

class RacingCarGame(private val user: User) {

    fun start() {
        showGameMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val cars = user.requestInputCarNames()

        showGameMessage("시도할 횟수는 몇 회인가요?")
        val moveCount = user.requestInputMoveCount()

        showGameMessage()

        showGameMessage("실행 결과")
        repeat(moveCount) {
            race(cars)
            showGameMessage()
        }

        val winnerNames = decideWinnerNames(cars)
        showGameMessage("최종 우승자 : ${winnerNames.joinToString(", ")}")
    }

    private fun showGameMessage(message: String = "") {
        println(message)
    }

    private fun race(cars: List<Car>) {
        cars.forEach {
            val conditionNumber = it.tryMoveForward()
            showRaceMessage(it.name, conditionNumber)
        }
    }

    private fun showRaceMessage(carName: String, conditionNumber: Int) {
        println("$carName : ${"-".repeat(conditionNumber)}")
    }

    private fun decideWinnerNames(cars: List<Car>): List<String> {
        val maxForwardCount = cars.maxOf { it.forwardCount }
        val winners = cars.filter { it.forwardCount == maxForwardCount }

        return winners.map { it.name }
    }
}