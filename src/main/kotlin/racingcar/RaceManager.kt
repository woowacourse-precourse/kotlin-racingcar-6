package racingcar

import racingcar.state.CarState

class RaceManager {

    companion object {
        const val DEFAULT_VALUE = 0
    }

    private val _raceCars: MutableList<Car> = mutableListOf()
    val raceCars: List<Car> get() = _raceCars.toList()

    private var movementAttemptCount: Int = DEFAULT_VALUE

    private val _movedDirection: HashMap<String, Int> = hashMapOf()
    val movedDirection : Map<String, Int> get() = _movedDirection.toMap()

    fun addCarToRace(car: Car) {
        _raceCars.add(car)
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

    fun startRace() {
        while (movementAttemptCount > DEFAULT_VALUE) {
            tryForwardMovementAllCars()
            displayAllCarsDirectionMoved()
            movementAttemptCount -= 1
            println()
        }
    }

    private fun tryForwardMovementAllCars() {
        _raceCars.map { car ->
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
        _raceCars.map { car ->
            displayCarDirectionMoved(car)
        }
    }

    private fun displayCarDirectionMoved(car: Car) {
        println("${car.name} : ")
        repeat(_movedDirection.getValue(car.name)) {
            print("-")
        }
    }

    private fun endRace(){
        _movedDirection.ge
    }
}