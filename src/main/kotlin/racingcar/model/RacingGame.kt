package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.OutputView

class RacingGame() {
    private val outputView = OutputView()
    fun playGame(racingCars: RacingCars) {
        var cnt = 0
        println("실행 결과")
        while(racingCars.tryCnt > cnt) {
            cnt++
            move(racingCars)
            outputView.printProgress(racingCars.carList)
        }
    }
    private fun move(racingCars: RacingCars) {
        for(racingCar in racingCars.carList) {
            val checkNum = generateNumber()
            if(haveCondition(checkNum)) {
                racingCar.distance += STR_DIST
            }
        }
    }
    private fun generateNumber() : Int {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM)
    }

    private fun haveCondition(num : Int) : Boolean {
        return num >= MOVE_CONDITION_NUM
    }

    companion object {
        private const val MIN_NUM = 0
        private const val MAX_NUM = 9
        private const val MOVE_CONDITION_NUM = 4
        private const val STR_DIST = "-"
    }
}
