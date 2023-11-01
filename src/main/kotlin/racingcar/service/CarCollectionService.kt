package racingcar.service

import racingcar.dto.CarDto
import racingcar.dto.WinnerDto
import racingcar.model.CarCollection

class CarCollectionService (carName: String) {
    val carCollection : CarCollection

    init {
        carCollection = CarCollection(carName)
    }

    fun getCarsDto(): MutableList<CarDto> {
        return carCollection.getCarsDto()
    }

    fun getWinnersDto(): MutableList<WinnerDto> {
        return carCollection.getWinnersDto()
    }
}