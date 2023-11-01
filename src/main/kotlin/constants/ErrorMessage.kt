package constants

object ErrorMessage {
    const val INPUT_NULL = "[ERROR] 아무것도 입력되지 않았습니다."
    const val INPUT_TYPE_BE_INT = "[ERROR] 숫자로 입력해야 합니다."

    const val INPUT_CAR_NAME_NULL = "[ERROR] 입력되지 않은 자동차 이름이 있습니다."
    const val INPUT_CAR_NAME_SIZE_OVER = "[ERROR] 자동차 이름은 5글자 이하여야 합니다."
    const val INPUT_TRY_NUM_SIZE_UNDER = "[ERROR] 시도 횟수는 1번을 이상이어야 합니다"
    const val INPUT_TRY_NUM_SIZE_OVER = "[ERROR] 시도 횟수는 100번을 미만이어야 합니다"
}