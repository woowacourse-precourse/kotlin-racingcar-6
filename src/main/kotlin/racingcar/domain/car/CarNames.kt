package racingcar.domain.car

import racingcar.domain.Constants


data class CarNames(val names: List<String>) {
    init {
        require(this.names.all { it.length <= 5 }) { Constants.LENGTH_ERROR_MESSAGE }
    }
}
