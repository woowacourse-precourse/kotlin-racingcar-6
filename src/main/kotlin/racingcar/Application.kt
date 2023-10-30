package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val CarList = inputCarList()
    val distanceList = MutableList(CarList.size) { 0 }

    println("시도할 횟수는 몇 회인가요?")
    val repeatCount = readLine()
    println("\n실행 결과")

}

fun inputCarList(): List<String>{
    val inputCarName = readLine()
    val CarList = inputCarName!!.split(",")
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