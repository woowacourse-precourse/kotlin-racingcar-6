import util.Validator.inputCarContentCheck

object CarFactory {
    fun makeCar(input: String): List<Car> {
        val makeCarList = inputCarContentCheck(input)
        val racingCarList = mutableListOf<Car>()
        makeCarList.forEach {
            racingCarList.add(Car(it))
        }
        return racingCarList
    }
}
