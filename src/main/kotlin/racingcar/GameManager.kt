package racingcar

import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val racingCarList = ArrayList<RacingCar>()
    private var trial = 0
    fun runRacingGame() {
        val inputManager = InputManager()

        // 경주 자동차 이름 입력
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        makeRacingCarList(inputManager.getRacingCarNameList())
        // 경주 시도 횟수 입력
        println("시도할 횟수는 몇 회인가요?")
        trial = inputManager.getTrial()
        // 입력된 정보를 기반으로 자동차 경주 게임 진행
        for (num in 1..trial) {
            proceedRacingGame()
        }
    }

    // 경주 자동차 이름을 기반으로 자동차 객체를 리스트에 추가
    private fun makeRacingCarList(racingCarNameList: List<String>) {
        for (racingCarName in racingCarNameList) {
            racingCarList.add(RacingCar(racingCarName))
        }
    }

    // 전진을 위한 랜덤 숫자 생성
    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    // 게임을 한 턴 진행
    private fun proceedRacingGame() {
        for (racingCar in racingCarList) {
            val randomNumber = generateRandomNumber()
            if (randomNumber >= 4) {
                racingCar.distance++
            }
        }
    }
}