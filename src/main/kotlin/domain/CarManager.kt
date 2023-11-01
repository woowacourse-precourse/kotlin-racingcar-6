package domain

class CarManager {
    private var cars: MutableList<Car> = mutableListOf()

    /**
     * 자동차 생성 및 CarManager 에 추가
     */
    fun makeCar(name: String){
        cars.add(Car(name))
    }
}