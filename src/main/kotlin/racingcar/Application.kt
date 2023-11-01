package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    playCarRace()
}

fun playCarRace(){
    val carNames = getCarNames()
    val tryNumber = getTryNumber()

    val raceResults = raceCars(carNames, tryNumber)
    printRaceResults(raceResults)
       
    val winners = findWinners(raceResults)
    printWinners(winners)    
    }



fun getCarNames():List<String> {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ")
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



fun raceCars(carNames: List<String>, tryNumber: Int): List<Pair<String, String>> {
    val raceResults = mutableListOf<Pair<String, String>>()
    
    for (carName in carNames) {       
        var result = ""
        for (i in 1..tryNumber) {
            val goOrStop = Randoms.pickNumberInRange(0, 9) 
            if (goOrStop >= 4){
                result += "-"
            } 
        }
        raceResults.add(Pair(carName, result))
    }
    return raceResults
}

fun printRaceResults(raceResults: List<Pair<String, String>>) {
    print("실행 결과:")
    raceResults.forEach {(carName, result) ->     
        println("$carName : $result")
    }
}

fun findWinners(raceResults: List<Pair<String, String>>) : List<String> {
    val maxPosition = raceResults.map{it.second.count { it =='-'}}.maxOrNull()

    if (maxPosition == null) {
        return emptyList()
    }
    return raceResults.filter { it.second.count{ it == '-'} == maxPosition}.map{it.first}
}


fun printWinners(winners: List<String){
    val winnerString = if (winners.size>1) winners.joinToString(",")  else winners.first()
    print("최종 우승자: $winnerString") 
}


