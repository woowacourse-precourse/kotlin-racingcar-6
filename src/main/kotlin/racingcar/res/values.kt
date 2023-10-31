package racingcar.res

object CarMovement {
  const val GO = true
  const val STOP = false
  const val GO_RECORD = "-"
}

object GuideMessage {
  const val ENTER_CAR_NAMES_GUIDEMESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
  const val ENTER_NUMBER_OF_MOVES_GUIDEMESSAGE = "시도할 횟수는 몇 회인가요?"
}

object ErrorMessage {
  const val EMPTY_CAR_NAME_ERRORMESSAGE = "자동차 이름을 입력해주세요."
  const val UNDER_5_LETTERS_CAR_NAME_ERRORMESSAGE = "자동차 이름을 5자 이하로 작성해주세요."
  const val INDISTINCTIVE_CAR_NAME_ERRORMESSAGE = "자동차 이름들을 구별되게 지어주세요."

  const val NOT_PROPER_NUMBER_OF_MOVES_ERRORMESSAGE = "올바른 횟수를 입력해주세요."
}