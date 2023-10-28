package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

object PlayerConsole {

    private fun parseInputByComma() = readLine().split(",")

    //확장 함수로 짠 이유 : getValidCarNames에서 메서드 체이닝으로 코드의 흐름을 한눈에 파악
    private fun List<String>.validateCarNames(): List<String> {
        require(this.all { it.length <= 5 && it.isNotEmpty() }) { "자동차 이름은 한 글자 이상, 5글자 이하로 입력해 주세요." }
        require(this.all { playerName -> playerName.all { it.isLetter() || it.isDigit() } }) { "문자와 숫자만 입력해 주세요." }
        require(this.toSet().size == this.size) { "자동차 이름은 서로 중복될 수 없습니다." }
        return this
    }

}