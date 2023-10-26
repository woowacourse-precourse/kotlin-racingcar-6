import util.CarValue.CAR_INIT_LENGTH_VALUE
import util.CarValue.DISTANCE_SYMBOL

class Car(name: String) : Acceleration {
    private var carName = name
    private var length = CAR_INIT_LENGTH_VALUE

    fun getName() = carName

    fun printCarInfo() {
        print("$carName : ")
        repeat(length) {
            print(DISTANCE_SYMBOL)
        }
        println()
    }

    fun lengthPlus(): Int {
        length++
        return length
    }
}
