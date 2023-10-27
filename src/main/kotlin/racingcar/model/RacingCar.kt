package racingcar.model

data class RacingCar(
    val name: String,
    val position: Int = 0,
    val raceRecord: String = "",
) {

    fun move(): RacingCar = copy(position = position + 1, raceRecord = "$raceRecord-")
}
