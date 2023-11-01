package racingcar

class RacingCarGameViewer {

    fun showRoundResult(racingCars: List<RacingCar>) {
        racingCars.map { racingCar -> println(racingCarMovedResult(racingCar)) }
    }

    private fun racingCarMovedResult(racingCar: RacingCar): String {
        return racingCar.getName() + BLANKED_COLON + DASH.repeat(racingCar.getPosition())
    }

    companion object {
        private const val BLANKED_COLON = " : "
        private const val DASH = "-"
    }
}