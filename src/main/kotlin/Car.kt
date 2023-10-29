import CarConfiguration.MAX_FLAG_VALUE
import CarConfiguration.MIN_FLAG_VALUE
import camp.nextstep.edu.missionutils.Randoms
import caroption.DashBoard
import caroption.Engine

class Car(name: String) {

    private val carName = name
    private val engine = Engine()
    private val dashBoard = DashBoard()

    fun start() {
        val startFlag = Randoms.pickNumberInRange(MIN_FLAG_VALUE, MAX_FLAG_VALUE)
        if (engine.start(startFlag)) {
            dashBoard.distPlus()
        }
    }

    fun printDist() {
        dashBoard.printDist(dashBoard.nowDist())
    }

    fun nowDist() = dashBoard.nowDist()

}
