package racingcar

class GameManager {

    companion object {
        const val DEFAULT_VALUE = 0
    }

    private val _gameCars: MutableList<Car> = mutableListOf()
    val gameCars: List<Car> get() = _gameCars.toList()

    private var movementAttemptCount: Int = DEFAULT_VALUE

    private val _movedDirection: HashMap<String, Int> = hashMapOf()

    fun addCarToGame(car: Car) {
        _gameCars.add(car)
        _movedDirection.put(key = car.name, value = DEFAULT_VALUE)
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

    fun startGame() {
        while (movementAttemptCount > DEFAULT_VALUE) {
            tryForwardMovementAllCars()
            displayAllCarsDirectionMoved()
            movementAttemptCount -= 1
            println()
        }
    }

    private fun tryForwardMovementAllCars() {
        _gameCars.map { car ->
            val carState = car.tryForwardMovement()
            handleCarState(carState, car.name)
        }
    }

    private fun handleCarState(carState: CarState, carName: String) {
        when (carState) {
            CarState.MOVING_FORWARD ->
                _movedDirection[carName] = _movedDirection.getValue(carName) + 1

            CarState.STOP -> Unit
        }
    }

    private fun displayAllCarsDirectionMoved() {
        _gameCars.map { car ->
            displayCarDirectionMoved(car)
        }
    }

    private fun displayCarDirectionMoved(car: Car) {
        println("${car.name} : ")
        repeat(_movedDirection.getValue(car.name)) {
            print("-")
        }
    }
}