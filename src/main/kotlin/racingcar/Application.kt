package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine().split(',')
    println("$carNames")

    for(car in carNames){
        if(car.length > 5) throw IllegalArgumentException("이름은 5자 이하만 가능합니다")
    }
}
