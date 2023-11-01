package racingcar.domain.distance.boxed

class Distance(private var _value: UInt) {

    val value
        get() = _value

    fun increase() {
        _value++
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Distance

        return _value == other._value
    }

    override fun hashCode(): Int {
        return _value.hashCode()
    }


    init {
        validateDistance(_value)
    }

    companion object {
        const val MIN_DISTANCE: UInt = 0u
        private fun validateDistance(value: UInt) {
            if (value < MIN_DISTANCE) {
                throw IllegalArgumentException("Distance must be at least $MIN_DISTANCE. but it was $value")
            }
        }

        fun zero() = Distance(MIN_DISTANCE)
    }


}