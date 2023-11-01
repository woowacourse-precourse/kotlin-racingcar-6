package racingcar

fun main() {
    val user = User()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val list: List<String> = user.getCarNames()

    println("시도할 횟수는 몇 회인가요?")
    val count: Int = user.getTryCount()

    val gameManager: GameManager = GameManager(list, count)
    gameManager.raceStart()
}
