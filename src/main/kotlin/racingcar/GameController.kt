package racingcar
import camp.nextstep.edu.missionutils.Console

class GameController {
    companion object {
        const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차의 이름들을 입력하세요.(이름은 쉼표(,) 기준으로 구분"
        const val INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }

    fun racingGame() {

    }

    private fun getCarNames(): List<String> {
        println(INPUT_CAR_NAME_MESSAGE)

    }
}