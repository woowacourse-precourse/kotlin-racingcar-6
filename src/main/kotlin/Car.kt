import util.CarValue.CAR_INIT_DISTANCE_VALUE
import util.CarValue.DISTANCE_SYMBOL
import java.math.BigInteger

class Car(name: String) : Acceleration {
    private var carName = name
    private var distanceTraveled = CAR_INIT_DISTANCE_VALUE.toBigInteger()

    fun getName() = carName

    fun printCarInfo() {
        print("$carName : ")
        var length = BigInteger.ZERO
        while (length < distanceTraveled) {
            print(DISTANCE_SYMBOL)
            length++
        }
        println()
    }

    fun lengthPlus() = ++distanceTraveled
}
