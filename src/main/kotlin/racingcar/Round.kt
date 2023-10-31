package racingcar

class Round {
    private var round: Int = 0

    fun init() {
        round = RoundInput().result()
    }

    fun getRound(): Int {
        return round
    }
}