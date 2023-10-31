package racingcar.domain

class Cars(private val determineMove: DetermineMove) {

    private val _carList = mutableListOf<Car>()
    val carList: List<Car>
        get() = _carList


    private val _carStateList = mutableListOf<Int>()

    fun createCar(carNames: List<String>) {
        carNames.forEach { name ->
            _carList.add(Car(name))
            _carStateList.add(0)
        }
    }

    fun getAdvanceStateList(): List<Int> {
        _carList.forEachIndexed { index, car ->
            _carStateList[index] = car.advanceState
        }
        return _carStateList
    }

    fun moveCars(){
        _carList.forEach { car ->
            if (determineMove.isMove())
                car.moveForward()
        }
    }

}