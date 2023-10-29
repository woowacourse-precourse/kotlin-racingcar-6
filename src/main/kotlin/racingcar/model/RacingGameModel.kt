package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.Values

class RacingGameModel {
    fun isCarAdvance(randomValue: Int): Boolean {
        if (Values.MINIMUN_RANDOM_NUMBER <= randomValue && randomValue < Values.CAR_ADVANCE_MINIMUM_NUMBER) {
            return false
        } else if (Values.CAR_ADVANCE_MINIMUM_NUMBER <= randomValue && randomValue < Values.MAXIMUM_RANDOM_NUMBER) {
            return true
        }
        else {
            throw Error("Critial Error while calling randomValue : called $randomValue")
        }
    }
    fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(Values.MINIMUN_RANDOM_NUMBER, Values.MAXIMUM_RANDOM_NUMBER)
    }
}