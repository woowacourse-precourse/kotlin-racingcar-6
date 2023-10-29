package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    readCarNames()
}

fun readCarNames(): List<String> {
    while (true) {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) ")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }


        //빈값 입력이거나, 2개 이상의 이름 받기,5글자 이하까지
        if (input == null) {
            throw IllegalArgumentException("입력이 없습니다.")
        } else if (carNames.size < 2) {
            throw IllegalArgumentException("이름은 최소 2개 이상 입력 해야 합니다.")
        } else if (carNames.all { it.length <= 5 }) {
            return carNames
        } else {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }

    }
}


