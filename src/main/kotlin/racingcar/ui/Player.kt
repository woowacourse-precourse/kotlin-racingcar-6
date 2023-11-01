package racingcar.ui

import camp.nextstep.edu.missionutils.Console

class Player {
    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine()?.split(",") ?: throw IllegalArgumentException("입력값이 없습니다.")
    }
}