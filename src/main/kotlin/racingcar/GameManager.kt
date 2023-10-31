package racingcar

import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val racingCarList = ArrayList<RacingCar>()
    private var trial = 0
    fun runRacingGame() {
        val inputManager = InputManager()

        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        makeRacingCarList(inputManager.getRacingCarNameList())
        println("시도할 횟수는 몇 회인가요?")
        trial = inputManager.getTrial()
    }

    private fun makeRacingCarList(racingCarNameList: List<String>) {
        for (racingCarName in racingCarNameList) {
            racingCarList.add(RacingCar(racingCarName))
        }
    }

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}