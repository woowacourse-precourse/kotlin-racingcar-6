package racingcar.domain.car

import racingcar.domain.Constants


data class CarNames(val names: List<String>) {
    init {
        require(names.all { it.isNotBlank() && it.length <= 5 }) { Constants.LENGTH_ERROR_MESSAGE }
    }
}
