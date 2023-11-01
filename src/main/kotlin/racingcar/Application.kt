package racingcar

fun main() {

    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n")
    val carNames = readLine()?.split(",")?.map { it.trim() }

    print("시도할 횟수는 몇 회인가요?\n")
    val tryCount = readLine()?.toIntOrNull()

    if (carNames == null || tryCount == null || carNames.isEmpty()) {
        println("입력값이 올바르지 않습니다.")
        return
    }

    val cars = carNames.map { Car(it) }
    val racingGame = RacingGame(cars, tryCount)
    racingGame.playGame()
}
