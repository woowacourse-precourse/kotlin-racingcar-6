package racingcar.service

import camp.nextstep.edu.missionutils.Console.*
class Input {
    fun inputName(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val name = readLine()
        return name.split(",")
    }

    fun inputCycle(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val cycle = readLine().toInt()
        // TODO: 예외 처리 함수 추가
        return cycle
    }
}