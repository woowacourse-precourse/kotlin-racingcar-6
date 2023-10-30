package racingcar

class GameManager {

    companion object{
        const val DEFAULT_VALUE = 0
    }

    private val _gameCars: MutableList<Car> = mutableListOf()
    val gameCars: List<Car> get() = _gameCars.toList()

    private var movementAttemptCount: Int = DEFAULT_VALUE

    var _gameState: GameState = GameState.INIT
        private set

    fun addCarToGame(car: Car) {
        _gameCars.add(car)
    }

    fun setMovementAttemptCount(input: String) {
        validateInput(input)
        movementAttemptCount = input.toInt()
    }

    private fun validateInput(input: String) {
        requireNotNull(input.toIntOrNull()) {
            "전진을 시도할 횟수는 0 혹은 양수만 입력하실 수 있습니다."
        }
        require(input.toInt() >= 0) {
            "전진을 시도할 횟수는 음수일 수 없습니다."
        }
    }
}