package racingcar.domain.car.boxed

data class CarName(val value: String) {
    init {
        validateNameLength(value)
    }

    companion object {
        const val MIN_NAME_LEN = 1
        const val MAX_NAME_LEN = 5

        private fun validateNameLength(name: String) {
            if (name.isBlank() || name.length > MAX_NAME_LEN) {
                throw IllegalArgumentException("car name length should be less than $MAX_NAME_LEN. but it was ${name.length}")
            }
        }
    }
}
