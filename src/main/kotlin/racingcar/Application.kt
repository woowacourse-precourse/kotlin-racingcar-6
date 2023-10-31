package racingcar

import camp.nextstep.edu.missionutils.Randoms 
import camp.nextstep.edu.missionutils.Console 

fun main() {
    
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    
    val inputNames = Console.readLine()
    val nameList = inputNames.split(",") 
    var carMap = mutableMapOf<String, Int>()
    
    for (name in nameList) {
        if (name.trim().length <= 5) {
            carMap.put(name.trim(), 0)
        } else {
            throw IllegalArgumentException()
        }
    }
    
    println("시도할 횟수는 몇 회인가요?")
    
    val moveConut = Console.readLine()
    
    println("\n실행결과\n")
    
    for (i in 0 until moveConut.toInt()) {
        playGames(carMap)
        printResult(carMap)
        println("")
    } 

    val maxValue = carMap.values.max()
    val winnerList: MutableList<String> = mutableListOf()
    for ((key, value) in carMap) {
        if (value == maxValue) {
            winnerList.add(key)
        }
    }
    
    val winners = winnerList.joinToString(", ")
    println("최종 우승자 : $winners")
}

fun playGames(carMap : MutableMap<String, Int>){

    for (car in carMap) {
        if (Randoms.pickNumberInRange(1, 9) >= 4) {
            carMap.put(car.key, car.value + 1)
        }    
    }
}

fun printResult(carMap : MutableMap<String, Int>) {
    
    for (car in carMap) {
        print("${car.key} : ")
        repeat(car.value) {print("-")}
        println("")
    }

} 