package racingcar.model

import racingcar.Car

data class Winner(val cars: List<Car>) {
    override fun toString(): String {
        return WINNER_MESSAGE.format(
            cars.joinToString(SEPARATOR) { car -> car.name }
        )
    }

    companion object {
        private const val WINNER_MESSAGE = "최종 우승자 : %s"
        private const val SEPARATOR = ", "
    }
}
