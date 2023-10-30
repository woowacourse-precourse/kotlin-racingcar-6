package racingcar.car

class RacingCar(
    name: String
) : Car(name) {
    override fun move() {
        position += POSITION_UNIT
    }

    companion object {
        private const val POSITION_UNIT = "-"
    }
}