package racingcar

fun main() {
    try {
        val carNames = CarRace.getCarNames()
        val moveCount = CarRace.getMoveCount()

        val carPositions = IntArray(carNames.size)

        println("\n자동차 경주 게임을 시작합니다!\n")

        repeat(moveCount) {
            CarMovement.moveCars(carNames, carPositions)
            CarResults.printCurrentPositions(carNames, carPositions)
        }

        val winners = CarResults.findWinners(carNames, carPositions)
        CarResults.printWinners(winners)
    } catch (e: IllegalArgumentException) {
        println("오류: 유효하지 않은 입력입니다. 게임을 종료합니다.")
    }
}
