package racingcar

class TryTime private constructor(val count: Int) {

    companion object {
        fun createOrThrow(input: String): TryTime {
            val count = input.toIntOrNull() ?: throw IllegalArgumentException()
            require(count > 0)
            return TryTime(count = count)
        }
    }
}
