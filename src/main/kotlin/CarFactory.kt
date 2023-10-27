import util.Validator.inputCarNameCheck

object CarFactory {
    fun makeCar(input: String): List<Car> {
        val makeCarList = inputCarNameCheck(input)
        val racingCarList = mutableListOf<Car>()
        makeCarList.forEach {
            racingCarList.add(Car(it))
        }
        return racingCarList
    }
}
