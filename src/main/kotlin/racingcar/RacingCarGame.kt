package racingcar

class RacingCarGame(private val user: User) {
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val cars = user.requestInputCarNames()

        println("시도할 횟수는 몇 회인가요?")
        val moveCount = user.requestInputMoveCount()

        println("실행 결과")
    }
}