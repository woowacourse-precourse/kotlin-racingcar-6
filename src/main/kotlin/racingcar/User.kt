package racingcar

import camp.nextstep.edu.missionutils.Console

class User {
    val validator = Validator()

    fun getCarNames(): List<String> {
        var carNames: String = Console.readLine()
        // validator로 올바른 문자열 입력인지 확인
        validator.validateInputString(carNames)
        // List로 쪼개기
        val nameList: List<String> = carNames.split(',')
        // validator로 올바른 길이의 이름인지 확인
        validator.validateNames(nameList)
        return nameList
    }

    fun getTryCount(): Int {
        
    }
}