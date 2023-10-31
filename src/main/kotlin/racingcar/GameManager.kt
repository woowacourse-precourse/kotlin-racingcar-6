package racingcar

class GameManager {
    fun runRacingGame() {
        val inputManager = InputManager()

        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val racingCarNameList = inputManager.getRacingCarNameList()
        println("시도할 횟수는 몇 회인가요?")
        val trial = inputManager.getTrial()
    }
}