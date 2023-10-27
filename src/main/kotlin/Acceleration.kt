import camp.nextstep.edu.missionutils.Randoms
import util.CarValue.MAX_RANDOM_VALUE
import util.CarValue.MIN_FORWARD_VALUE
import util.CarValue.MIN_RANDOM_VALUE

abstract class Acceleration {
    fun isGo() = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= MIN_FORWARD_VALUE
}
