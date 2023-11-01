package racingcar.model

import racingcar.exceptions.BlankNameException
import racingcar.exceptions.UnvalidNameLengthException
import racingcar.exceptions.UnvalidRoundNumberException

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