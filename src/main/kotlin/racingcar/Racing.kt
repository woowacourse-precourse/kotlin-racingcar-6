package racingcar

class Racing {
    fun makeCar(): List<String> {
        val inputString = Input().inputCar()
        val delim = ","
        val carList = inputString.split(delim)
        Validation().validCar(carList)
        return carList
    }
}