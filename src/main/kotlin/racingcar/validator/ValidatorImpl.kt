package racingcar.validator

class ValidatorImpl : Validator {
    override fun nameLength(name: String) {
        require(name.length in MINIMUM_NAME_LENGTH..MAXIMUM_NAME_LENGTH)
    }

    override fun attemptsComponents(attempts: String) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val MINIMUM_NAME_LENGTH = 1
        private const val MAXIMUM_NAME_LENGTH = 5
    }
}
