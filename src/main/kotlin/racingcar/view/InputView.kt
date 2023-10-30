package racingcar.view

class InputView {
    fun printInputCarName() = println(INPUT_CAR_NAME_MESSAGE)
    fun printInputGameCount() = println(INPUT_GAME_COUNT_MESSAGE)

    companion object {
        const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_GAME_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}