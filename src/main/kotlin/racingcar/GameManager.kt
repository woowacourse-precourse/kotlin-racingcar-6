package racingcar

class GameManager {
    private val _gameCars: MutableList<Car> = mutableListOf()
    val gameCars: List<Car> get() = _gameCars.toList()

    fun addCarToGame(car : Car){
        _gameCars.add(car)
    }


}