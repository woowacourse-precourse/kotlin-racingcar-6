package racingcar.domain.distance.boxed

class Distance(var distance: UInt) {
    fun increase() {
        distance++
    }

    init {
        validateDistance(distance)
    }

    companion object {
        const val MIN_DISTANCE: UInt = 0u
        private fun validateDistance(distance: UInt) {
            if (distance < MIN_DISTANCE) {
                throw IllegalArgumentException("Distance must be at least $MIN_DISTANCE. but it was $distance")
            }
        }

        fun zero() = Distance(MIN_DISTANCE)
    }
}