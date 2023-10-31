package car

import camp.nextstep.edu.missionutils.Randoms
import car.CarConfiguration.MAX_FLAG_VALUE
import car.CarConfiguration.MIN_FLAG_VALUE
import caroption.DashBoard
import caroption.Engine

class Car(
    private val engine: Engine,
    private val dashBoard: DashBoard
) {

    fun printCarName() {
        print(dashBoard.carName())
    }

    fun start() {
        val startFlag = Randoms.pickNumberInRange(MIN_FLAG_VALUE, MAX_FLAG_VALUE)
        if (engine.start(startFlag)) {
            dashBoard.distPlus()
        }
    }

    fun printDist() {
        print(dashBoard.printDist())
    }

    fun nowDist() = dashBoard.nowDist()
}
