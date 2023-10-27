package racingcar

object Constants {
    const val INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val INPUT_TRIAL_NUM = "시도할 횟수는 몇 회인가요?"

    const val TRIAL_RESULT = "실행 결과"
    const val WINNERS = "최종 우승자"

    const val MOVE_SIGN = "-"

    const val EXCEPTION_TRIAL_NUM = "시도 횟수는 숫자 형태로만 입력할 수 있습니다."
    const val EXCEPTION_CAR_NUM = "자동차는 2대 이상만 가능합니다."
    const val EXCEPTION_CAR_NAME_LENGTH = "자동차 이름의 길이는 1자 이상 5자 이하만 가능합니다."
    const val EXCEPTION_CAR_NAME_STARTS_WITH_BLANK = "자동차 이름은 공백으로 시작할 수 없습니다."
    const val EXCEPTION_CAR_NAME_DUPLICATION = "자동차 이름은 중복으로 사용할 수 없습니다."
}