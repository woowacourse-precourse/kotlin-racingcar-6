package racingcar.model

import racingcar.util.Validator.isCarNameLengthValid
import racingcar.util.Validator.isCarNameNotEmpty
import racingcar.util.Validator.isCarNameUnique

class Cars(private val carNameList: List<String>) {

    private var _carNames = getValidCarName()

    val carList: List<Car>
        get() = _carList
    private var _carList = initializeCars()

    private fun getValidCarName(): List<String> {
        isCarNameUnique(carNameList)
        carNameList.forEach { name ->
            isCarNameLengthValid(name)
            isCarNameNotEmpty(name)
        }
        _carNames = carNameList
        return _carNames
    }

    private fun initializeCars(): List<Car> {
        val initializedCarList: List<Car> = _carNames.indices.map { Car(name = "", distance = 0) }
        _carNames.forEachIndexed { idx, name -> initializedCarList[idx].name = name }
        return initializedCarList
    }

}