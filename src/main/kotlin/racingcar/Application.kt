package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val carList = inputCarList()
    val distanceList = MutableList(carList.size) { 0 }

    println("시도할 횟수는 몇 회인가요?")
    val repeatCount = readLine()
    judgementException("repeatCount", repeatCount.toString())
    println("\n실행 결과")
    for (i in 0..repeatCount!!.toInt()-1) { // allCarList.indices는 0 부터 allCarList.size - 1 까지의 범위를 제공합니다.
        showProcedure(carList, forwardCondition(distanceList))
    }
    finalWinner(carList, distanceList)
}

fun inputCarList(): List<String>{
    val inputCarName = readLine()
    val CarList = inputCarName!!.split(",").map { it.trim() } // 각 아이템 주변의 공백 제거

    CarList.forEach {
        judgementException("inputCar", it)
    }
    return CarList
}

fun forwardCondition(distanceList: MutableList<Int>): MutableList<Int>{

    var randomNumber: Int

    for(i in distanceList.indices){
        randomNumber = Randoms.pickNumberInRange(0, 9)
        if(randomNumber > 4)
            distanceList[i] += 1
    }

    return distanceList
}

fun showProcedure(carList: List<String>, distanceList: MutableList<Int>){
    for(i in distanceList.indices){
        print("${carList[i]} : ")
        println("-".repeat(distanceList[i]))
    }
    println()
}

fun finalWinner(carList: List<String>, distanceList: MutableList<Int>) {
    val maxDistance = distanceList.maxOrNull() // 리스트에서 가장 큰 값을 찾습니다.
    if (maxDistance != null) {
        val winners = distanceList.mapIndexedNotNull { index, value ->
            if (value == maxDistance) carList[index] else null // 최댓값과 동일하면 해당 차의 이름을 반환하고, 아니면 null을 반환합니다.
        }
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}

fun judgementException(judge: String, carName: String){
    when(judge){
        "inputCar" -> {
            stringLenthJudgement(carName)
        }
        "repeatCount" -> {
            isNumber(carName)
        }
    }
}

fun stringLenthJudgement(carName: String){
    if (carName.length >= 6) {
        throw IllegalArgumentException()
    }
}

fun isNumber(carName: String){
    if (!carName.all { it.isDigit() }) {
        throw IllegalArgumentException()
    }
}
