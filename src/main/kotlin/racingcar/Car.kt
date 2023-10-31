package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var movingDistance: Int) {
    fun chooseGoOrStop() {
        val randomNumber: Int = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4){
            this.movingDistance += 1
        }
    }
}