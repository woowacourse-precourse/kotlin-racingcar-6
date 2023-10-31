package racingcar

class CarManager {
    fun separateCarNames(carNames: String): List<String> = carNames.split(",")

    fun makeCarModelList(carNames: List<String>): List<Car> {
        var modelList = mutableListOf<Car>()
        carNames.forEach {
            modelList.add(Car(it))
        }
        return modelList.toList()
    }
}