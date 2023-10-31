package racingcar
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

data class Car(val name: String, var distance: Int = 0) {
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }
fun main() {

}

