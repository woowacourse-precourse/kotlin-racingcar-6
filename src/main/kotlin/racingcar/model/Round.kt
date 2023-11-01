package racingcar.model

import UnvalidRoundNumberException

class Round (private val roundNumber : Int) {

    init {
        checkValidateRound()
    }

    private fun checkValidateRound() {
        if (roundNumber <= 0)
            throw UnvalidRoundNumberException()
    }

    fun getRound(): Int {
        return roundNumber
    }
}