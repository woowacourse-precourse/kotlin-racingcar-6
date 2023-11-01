package racingcar.model
import camp.nextstep.edu.missionutils.Randoms

object Generator {
    fun numberGenerator(): Int {
        return Randoms.pickNumberInRange(0,9)
    }
}