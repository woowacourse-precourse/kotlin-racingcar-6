package racingcar

// import kotlin.collections.mutableMapOf
import java.util.Random
import kotlin.text.toInt

// import camp.nextstep.edu.missionutils.Randoms //pickNumberInRange
// import camp.nextstep.edu.missionutils.Console //readLine

fun main() {
    
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    
    val inputNames = readLine()
    val nameList = inputNames?.split(",") 
    var carMap = mutableMapOf<String, Int>()
    
    for (name in nameList!!) {
        if (name.trim().length <= 5) {
            carMap.put(name.trim(), 0)
        } else {
            throw IllegalArgumentException()
        }
    }
    
    println("시도할 횟수는 몇 회인가요?")
    
    val moveConut = readLine()
    
    println("실행결과\n")
    
    for (i in 0 until moveConut!!.toInt()) {
        playGames(carMap)
        printResult(carMap)
        println("")
    } 
}

fun playGames(carMap : MutableMap<String, Int>){
    
    val random = Random()

    for (car in carMap) {
        if (random.nextInt(10) >= 4) {
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
