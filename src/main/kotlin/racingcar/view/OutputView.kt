package racingcar.view

import racingcar.view.Constant.INPUT_RACINGCAR_NAME_MASSAGE
class OutputView {

    fun printInputRacingcarName() = println(INPUT_RACINGCAR_NAME_MASSAGE)
}

object Constant {
    const val INPUT_RACINGCAR_NAME_MASSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val TRY_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
    const val RESULT_MESSAGE = "실행 결과"
}