package racingcar

class CarCollection {
    val carList:MutableList<Car> = mutableListOf()

    fun putCar(car:Car){
        carList.add(car)
    }
    fun moveCars(){
        for(car in carList){
            car.moveCar()
        }
    }
    fun showResults(){
        for(car in carList){
            car.showResult()
        }
        println()
    }
}