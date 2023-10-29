package racingcar.model.car

@JvmInline
value class CarName(val name: String) {
    init {
        require(name.length <= MAX_NAME_LENGTH) { CAR_NAME_LENGTH_EXCEPTION }
    }

    // Car에서 이름을 출력하려면 car.name.name 해야하는 것을 막기 위함
    override fun toString(): String {
        return name
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val CAR_NAME_LENGTH_EXCEPTION = "CarName must be shorter than or equal to 5 characters"
    }

}