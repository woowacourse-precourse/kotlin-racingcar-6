package racingcar

class GameManager(
    val nameList: List<String>,
    val tryCount: Int,
    var carsList: MutableList<Car>
) {
    constructor(nameList: List<String>, tryCount: Int) : this(nameList, tryCount, mutableListOf()) {
        createCarList(nameList)
    }

    fun createCarList(nameList: List<String>) {
        for (name in nameList) {
            this.carsList.add(Car(name, ""))
        }
    }

}