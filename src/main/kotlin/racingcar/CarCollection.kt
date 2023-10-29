package racingcar

class CarCollection {
    val carList:MutableList<Car> = mutableListOf()

    fun putCar(car:Car){
        carList.add(car)
    }
}