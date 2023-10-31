package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.Values

class RacingGameModel {
    fun raceTrial(carList: MutableList<Pair<String, Int>>): MutableList<Pair<String, Int>> {
        for(i in 0 until carList.count()) {
            carList[i] = carList[i].copy(second = carList[i].second + isCarAdvance(getRandomNumber()).compareTo(false))
        }
        return carList
    }
    private fun isCarAdvance(randomValue: Int): Boolean {
        return if (Values.MINIMUN_RANDOM_NUMBER <= randomValue && randomValue < Values.CAR_ADVANCE_MINIMUM_NUMBER) {
            false
        } else if (Values.CAR_ADVANCE_MINIMUM_NUMBER <= randomValue && randomValue <= Values.MAXIMUM_RANDOM_NUMBER) {
            true
        }
        else {
            throw Error("Critial Error while calling randomValue : called $randomValue")
        }
    }
    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(Values.MINIMUN_RANDOM_NUMBER, Values.MAXIMUM_RANDOM_NUMBER)
    }
}