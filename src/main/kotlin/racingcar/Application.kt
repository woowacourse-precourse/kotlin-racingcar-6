package racingcar

fun main() {
        val carNames = CarRace.getCarNames()
        val moveCount = CarRace.getMoveCount()
        val moveCountResult = runCatching { moveCount }

        if (carNames is IllegalArgumentException) {
            println("${(carNames as IllegalArgumentException).message} 애플리케이션을 종료합니다.")
            return
        }
        moveCountResult.onFailure { e ->
            println("오류: ${e.message}\n프로그램을 종료합니다.")
        }


        val carPositions = IntArray(carNames.size)

        println("\n자동차 경주 게임을 시작합니다!\n")

        repeat(moveCount) {
            CarMovement.moveCars(carNames, carPositions)
            CarResults.printCurrentPositions(carNames, carPositions)
        }

        val winners = CarResults.findWinners(carNames, carPositions)
        CarResults.printWinners(winners)
}
