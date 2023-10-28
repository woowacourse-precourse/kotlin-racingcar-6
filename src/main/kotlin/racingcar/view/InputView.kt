package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        private const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_REPOTITION = "시도할 횟수는 몇 회인가요?"
    }


    // TODO: 매직 스트링 제거
    fun promptCarNames(): String {
        println(INPUT_CAR_NAMES)
        return Console.readLine() ?: throw IllegalArgumentException("자동차 이름이 입력되지 않았습니다.")
    }

    fun promptRepetition(): String {
        println(INPUT_REPOTITION)
        return Console.readLine() ?: throw IllegalArgumentException("시도할 횟수가 입력되지 않았습니다.")
    }
}