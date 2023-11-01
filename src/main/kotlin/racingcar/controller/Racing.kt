package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.view.OutputView

class Racing(
    private val outputView: OutputView,
    private val count: Int,
    private val cars: MutableList<Car>
) {
    companion object {
        const val MOVE_NUM: Int = 4
    }

    init {
        repeat(this.count) { startRacing() }
    }

    private fun generateRandomNumber() = Randoms.pickNumberInRange(0, 9)
    private fun resultOutput(name: String, score: Int) = outputView.resultOutput(name, score)

    private fun isMove(): Boolean {
        val num = generateRandomNumber()
        return num >= MOVE_NUM
    }

    private fun startRacing() {
        for(car in this.cars) {
            if(isMove()) { car.move() }
            resultOutput(car.name, car.score)
        }
        println()
    }
}
