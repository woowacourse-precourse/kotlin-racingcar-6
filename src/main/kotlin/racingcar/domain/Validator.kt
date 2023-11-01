package racingcar.domain

class Validator(inputCarNames: String, inputRound: Int) {

    init {
        validateLength(inputCarNames)
        validateDuplicate(inputCarNames)
        validateRound(inputRound)
    }

    companion object {

        private fun validateLength(inputCarNames: String) {
            val listCars = inputCarNames.split(',').toList()
            listCars.forEach { car ->
                if (car.length > 5)
                    throw IllegalArgumentException("이름은 5자 이하만 가능합니다.")
            }
        }

        private fun validateDuplicate(inputCarNames: String) {
            val listCars = inputCarNames.split(',').toList()
            if (HashSet(listCars).size != listCars.size) {
                throw IllegalArgumentException("중복된 이름이 존재하면 안 됩니다.")
            }
        }

        private fun validateRound(inputRound: Int) {
            if (inputRound < 0 || inputRound > 100) {
                throw IllegalArgumentException("1 ~ 100 사이의 숫자를 입력해주세요.")
            }
        }
    }
}