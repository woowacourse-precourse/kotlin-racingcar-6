package racingcar.model
import camp.nextstep.edu.missionutils.Randoms

private const val FORWARD_MIN_VALUE = 4

class CarModel(val name: String, var position: Int = 0) {
    fun move(num: Int) {
        if(num >= FORWARD_MIN_VALUE) position++
    }

    fun numberGenerator(): Int {
        return Randoms.pickNumberInRange(0,9)
    }
}