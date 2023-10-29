package racingcar.model

class Cars (carsList: MutableList<Car>){
    private var cars: MutableList<Car> = mutableListOf()

    init {
        this.cars = carsList
    }
}