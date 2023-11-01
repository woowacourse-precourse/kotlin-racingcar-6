package racingcar.domain

class Validator(inputCarsNames: String, inputRound: Int) {

    init {
        validateLength(inputCarsNames)
        validateDuplicate(inputCarsNames)
        validateRound(inputRound)
    }

    companion object {

        private fun validateLength(inputCarsNames: String) {
            val carList = inputCarsNames.split(',').toList()
            carList.forEach { car ->
                if (car.length > 5) {
                    throw IllegalArgumentException("이름은 5자 이하만 가능합니다.")
                }
            }
        }

        private fun validateDuplicate(inputCarsNames: String) {
            val carList = inputCarsNames.split(',').toList()
            if (HashSet(carList).size != carList.size) {
                throw IllegalArgumentException("중복된 이름이 존재하면 안 됩니다.")
            }
            if (carList.size != 1) {
                throw IllegalArgumentException("2대 이상의 차가 필요합니다.")
            }

        }

        private fun validateRound(inputRound: Int) {
            if (inputRound < 0 || inputRound > 100) {
                throw IllegalArgumentException("1 ~ 100 범위의 숫자만 입력 가능합니다.")
            }
        }
    }
}