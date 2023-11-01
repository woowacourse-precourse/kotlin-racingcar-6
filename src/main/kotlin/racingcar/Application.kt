package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.getTryNumber


fun main() {
    // TODO: 프로그램 구현
}

fun playCarRace(){
    while(true) {
        val carName = getCarNames()
        var tryNumberToPlayGame = getTryNumber()
        
        for (tryNumberToPlayGame) {
            carGoOrStop()
        }
        }
    }



fun getCarNames():List<String> {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val userInput = Console.readLine()
    val carNames = userInput?.split(",")?.map{it.trim()}

    return carNames
}

fun vaildationCarNames(userInput: String){
    if (userInput.length > 5){
        throw IllegalArgumentException("5자 이하만 입력 가능합니다.")
    }
}

fun getTryNumber():Int {
    print("시도할 횟수는 몇 회인가요?")
    val tryNumber = Console.readLine()

    return tryNumber
}

fun validateTryNumber(tryNumber: String) {
    try {
        tryNumber.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자만 입력 가능합니다.")
    }
}



fun carGoOrStop() {
    val goOrStop = Randoms.pickNumberInRange() 

    if (goOrStop >= 4){
        print("-")
    }
}

fun printWinner(){
    print("")
}


