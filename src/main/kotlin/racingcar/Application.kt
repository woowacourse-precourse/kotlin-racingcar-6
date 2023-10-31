package racingcar

fun main() {
    // 자동차 이름 입력
    val carNames = CarRace.getCarNames()

    // 시도 횟수 입력 및 예외 처리
    val moveCount = CarRace.getMoveCount()
    val moveCountResult = runCatching { moveCount }
    handleExceptions(carNames, moveCountResult)

    // 게임 시작 메시지 출력
    println("\n자동차 경주 게임을 시작합니다!\n")

    // 자동차 위치 배열 초기화
    val carPositions = IntArray(carNames.size)

    // 지정된 횟수만큼 게임 루프 실행
    repeat(moveCount) {
        CarMovement.moveCars(carNames, carPositions)
        CarResults.printCurrentPositions(carNames, carPositions)
    }

    // 최종 우승자 찾고 출력
    val winners = CarResults.findWinners(carNames, carPositions)
    CarResults.printWinners(winners)
}
