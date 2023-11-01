package racingcar.service

import racingcar.dto.CarDTO
import racingcar.dto.WinnerDTO
import racingcar.model.CarCollection

class CarCollectionService (carName: String) {
    val carCollection : CarCollection

    init {
        carCollection = CarCollection(carName)
    }

    fun getCarsDto(): MutableList<CarDTO> {
        return carCollection.getCarsDto()
    }

    fun getWinnersDto(): MutableList<WinnerDTO> {
        return carCollection.getWinnersDto()
    }
}