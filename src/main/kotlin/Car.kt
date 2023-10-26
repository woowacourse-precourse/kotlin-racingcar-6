import util.CarValue.CAR_INIT_LENGTH_VALUE

class Car(name: String) {
    private var carName = name
    private var length = CAR_INIT_LENGTH_VALUE

    fun printName() {
        print(carName)
    }
}
