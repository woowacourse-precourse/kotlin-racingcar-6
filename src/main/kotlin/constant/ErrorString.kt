package constant

class ErrorString {
    companion object {
        const val NO_INPUT_ERROR = "자동차 이름을 입력해주세요."
        const val INPUT_VALUE_ERROR = "올바른 자동차 이름을 입력해 주세요."
        const val INPUT_LENGTH_ERROR = "자동차 이름의 길이는 1에서 5사이여야 합니다."
        const val INPUT_REPEAT_ERROR = "중복된 자동차 이름이 있습니다."
        const val INTEGER_INPUT_ERROR = "정수를 입력하세요."
        const val INTEGER_RANGE_ERROR = "범위 안의 정수를 입력하세요."
        const val CAR_COUNT_ERROR = "두 대 이상의 자동차가 있어야 합니다."
    }
}