package racingcar

class Validator {
    // 요구사항 검증, 전진 조건 검증을 담당
    fun validateUserInput(carNamesList: List<String>) {
        // 자동차의 이름이 5자 이하인지 검증 기능
        if (carNamesList.any { it.length > 5 }) {
            throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
        }


        // 시도 횟수가 숫자가 맞는지 검증 기능

    }

    // 랜덤값이 전진하는 조건에 일지하는지 검증 기능

}