package racingcar

class GameManager {
    private val racingCarList = ArrayList<RacingCar>()
    fun runRacingGame() {
        val inputManager = InputManager()

        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        makeRacingCarList(inputManager.getRacingCarNameList())
        println("시도할 횟수는 몇 회인가요?")
        val trial = inputManager.getTrial()
    }

    private fun makeRacingCarList(racingCarNameList: List<String>) {
        for (racingCarName in racingCarNameList) {
            racingCarList.add(RacingCar(racingCarName))
        }
    }
}