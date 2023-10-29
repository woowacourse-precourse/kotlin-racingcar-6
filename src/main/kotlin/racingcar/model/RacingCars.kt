package racingcar.model

class RacingCars() {
    var carList: MutableList<RacingCar> = mutableListOf()
    var tryCnt : Int = 0

    fun add(racingCar: RacingCar) {
        carList.add(racingCar)
    }
}