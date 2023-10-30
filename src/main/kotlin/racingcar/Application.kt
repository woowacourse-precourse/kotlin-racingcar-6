package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
fun main() {
    // TODO: 프로그램 구현

}

fun generateCars(): List<String> {
    println(INPUT_CAR_NAMES)
    val carNames = Console.readLine().split(",").map { it.trim() }.requireNoNulls()
    carNames.forEach {
        if(it.length <= 5) return carNames
        else throw IllegalArgumentException("이름은 1자이상 5자 이하로 입력해주세요.")
    }
    return carNames
}

fun getAttemptTimes(): Int {
    val attemptTimes = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
    return  attemptTimes
}
fun isValidateInput(carNames:String,attemptTimes:Int): Boolean{
    if(carNames.isBlank()) throw IllegalArgumentException ("이름을 입력해주세요")
    if(carNames.isEmpty() && carNames.length > 5) throw IllegalArgumentException ("이름은 1자 이상 5자 이하로 입력해주세요.")
    if(attemptTimes.equals(" ")) throw IllegalArgumentException ("공백 없이 입력해주세요")
    return true
}