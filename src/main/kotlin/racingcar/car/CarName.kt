package racingcar.car

@JvmInline
value class CarName(val name: String) {

    init {
        require(name.length <= 5) { CAR_NAME_LENGTH_EXCEPTION }
    }

    companion object {
        private const val CAR_NAME_LENGTH_EXCEPTION = "CarName must be less than or equal to 5 characters"
    }

}