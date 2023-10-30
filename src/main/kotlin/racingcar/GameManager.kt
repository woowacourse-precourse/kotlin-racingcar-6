package racingcar

class GameManager {
    private val _gameCars: MutableList<Car> = mutableListOf()
    val gameCars: List<Car> get() = _gameCars.toList()

    private var movementAttemptCount : Int = 0

    enum class GameState{
        INIT, INPROGRESS, ENDED
    }

    fun addCarToGame(car : Car){
        _gameCars.add(car)
    }

    fun setMovementAttemptCount(input : String){
        requireNotNull(input.toIntOrNull()){
            "전진을 시도할 횟수는 0 혹은 양수만 입력하실 수 있습니다."
        }
        require(input.toInt() >= 0){
            "전진을 시도할 횟수는 음수일 수 없습니다."
        }

        movementAttemptCount = input.toInt()
    }
}