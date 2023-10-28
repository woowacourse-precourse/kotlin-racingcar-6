<<<<<<< HEAD
import util.CarValue.CAR_INIT_DISTANCE_VALUE
import util.CarValue.DISTANCE_SYMBOL
import java.math.BigInteger

class Car(name: String) : Acceleration() {
    private var carName = name
    private var distanceTraveled = CAR_INIT_DISTANCE_VALUE.toBigInteger()

    fun printCarInfo() {
        print("$carName : ")
        var length = BigInteger.ZERO
        while (length < distanceTraveled) {
            print(DISTANCE_SYMBOL)
            length++
        }
        println()
    }

    fun getCarName() = carName

    fun lengthPlus() = ++distanceTraveled
=======
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

>>>>>>> 85954de (feat: Car start 기능 작성)
}
