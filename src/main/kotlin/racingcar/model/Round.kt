package racingcar.model

@JvmInline
value class Round(private val value: Int) {

    fun forEach(action: (Round) -> Unit) = toListOfRounds().forEach(action)

    fun toListOfRounds(): List<Round> = (START_ROUND..value).map { Round(it) }

    companion object {
        private const val START_ROUND = 1

        fun from(roundString: String): Round {
            val round = roundString.validatePositiveNumber().getOrThrow().toInt()
            return Round(round)
        }
    }
}