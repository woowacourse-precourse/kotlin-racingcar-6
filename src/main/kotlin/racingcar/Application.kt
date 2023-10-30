package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
fun main() {
    class Car(val name: String) {
        init {
            require(name.length <= 5) { "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" }
        }
    }
}
