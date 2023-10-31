package racingcar.validator

class ValidatorImpl : Validator {
    override fun nameLength(name: String) {
        require(name.length in MINIMUM_NAME_LENGTH..MAXIMUM_NAME_LENGTH)
    }

    override fun attemptsComponents(attempts: String) {
        for (char in attempts) {
            require(char in MINIMUM_NUMBER..MAXIMUM_NUMBER)
        }
    }

    companion object {
        private const val MINIMUM_NAME_LENGTH = 1
        private const val MAXIMUM_NAME_LENGTH = 5
        private const val MINIMUM_NUMBER = '0'
        private const val MAXIMUM_NUMBER = '9'
    }
}
