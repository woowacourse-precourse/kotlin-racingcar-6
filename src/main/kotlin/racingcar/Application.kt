package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: 프로그램 구현
}

fun getCarNames():List<String> {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val userInput = Console.readLine()
    val carName = userInput.split(",")

    return carName
}

fun getTryNumber() {
    print("시도할 횟수는 몇 회인가요?")
    val tryNumber = Console.readLine()

    return tryNumber
}

fun carGoOrStop() {
    val goOrStop = Randoms.pickNumberInRange()

    if (goOrStop >= 4){
        print("-")
    }
}

