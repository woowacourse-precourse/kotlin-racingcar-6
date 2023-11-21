package errorMessage

enum class InputError(val message: String) {
    NOT_DIGIT("[Error]게임 횟수는 1이상의 숫자로만 입력해야합니다."),
    OVER_FIVE("[Error]5글자 이상의 이름이 입력되었습니다."),
}