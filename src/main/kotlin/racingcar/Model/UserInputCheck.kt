package racingcar.Model

class UserInputCheck {

    fun carNameErrorController(inputCarNames: String): List<String> {

        var carNames = carNameSplit(inputCarNames)
        carNameDuplicationCheck(carNames)
        carNameLengthCheck(carNames)

        return carNames
    }


    fun roundNumberErrorController(userRoundInput: String): Int {

        if (userRoundInput.toIntOrNull() == null || userRoundInput.toInt() <= 0) {
            throw IllegalArgumentException("시도할 횟수는 자연수만 입력해주세요.")
        }

        return userRoundInput.toInt()
    }

    private fun carNameSplit(carNames: String): List<String> {

        return carNames.split(",")
    }

    private fun carNameLengthCheck(carNames: List<String>) {
        for (carName in carNames) {
            if (carName.length > 5)
                throw IllegalArgumentException("자동차의 이름은 5자리 이하로 입력해주세요.")
        }
    }

    private fun carNameDuplicationCheck(carNames: List<String>) {
        val uniqueCarName = HashSet<String>()

        for (carName in carNames) {
            if (!uniqueCarName.add(carName)) {
                throw IllegalArgumentException("자동차의 이름은 중복되지 않게 입력해주세요.")
            }
        }
    }
}


