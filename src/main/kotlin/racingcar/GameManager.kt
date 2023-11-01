package racingcar

import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val racingCarList = ArrayList<RacingCar>()
    private val winnerRacingCarList = ArrayList<RacingCar>()
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
        println("실행 결과")
        for (num in 1..trial) {
            proceedRacingGame()
            printRacingGameResultPerTrial()
        }
        // 경주 결과 비교 및 출력
        setGameResult()
        printGameResult()
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

    // 각 차수별 실행 결과 출력
    private fun printRacingGameResultPerTrial() {
        for (racingCar in racingCarList) {
            val distance = "-".repeat(racingCar.distance)
            println("${racingCar.name} : $distance")
        }
        println()
    }

    // 경주 결과 비교
    private fun setGameResult() {
        // 경주 결과 집계 및 최고 거리 선정
        val distanceList = ArrayList<Int>()
        for (racingCar in racingCarList) {
            distanceList.add(racingCar.distance)
        }
        val winnerDistance = distanceList.max()

        // 최고 거리에 해당하는 경주 자동차 선정
        for (racingCar in racingCarList) {
            if (racingCar.distance == winnerDistance) {
                winnerRacingCarList.add(racingCar)
            }
        }
    }

    // 경주 결과 출력
    private fun printGameResult() {
        print("최종 우승자 : ")
        for (racingCar in winnerRacingCarList) {
            if (winnerRacingCarList.indexOf(racingCar) == 0) {
                print(racingCar.name)
            } else {
                print(", ${racingCar.name}")
            }
        }
    }
}