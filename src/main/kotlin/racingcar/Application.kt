package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position = 0
        private set
    init {
        require(name.length <= 5){ "Car name length exceeds 5 letters" }
    }
    fun goForwardOrStop() {
        val random = Randoms.pickNumberInRange(0,9)
        if (random >= 4) {
            position++
        }
    }
}

fun main() {
    // TODO: 프로그램 구현
}
