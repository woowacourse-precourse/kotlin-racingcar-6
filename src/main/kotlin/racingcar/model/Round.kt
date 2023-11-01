package racingcar.model

private const val MIN_ROUND = 1
private const val MAX_ROUND = 1000
private const val ILLEGAL_ROUND_EXCEPTION = "진행할 라운드는 0보다 크고 1000보다 작아야 합니다!"

class Round(val value: Int) {

    init {
        require(value in MIN_ROUND..MAX_ROUND) { ILLEGAL_ROUND_EXCEPTION }
    }
}