package racingcar.model

data class RaceResult(val carStateList: List<CarState>) {
    override fun toString(): String {
        return carStateList.joinToString(NEW_LINE) + NEW_LINE
    }

    companion object {
        private const val NEW_LINE = "\n"
    }
}