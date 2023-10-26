import util.CarValue.CAR_INIT_LENGTH_VALUE
import util.CarValue.DISTANCE_SYMBOL

class Car(name: String) {
    private var carName = name
    private var length = CAR_INIT_LENGTH_VALUE

    fun printName() {
        print(carName)
    }

    fun printLength() {
        repeat(length) {
            print(DISTANCE_SYMBOL)
        }
    }

    private fun lengthPlus() = length++
}
