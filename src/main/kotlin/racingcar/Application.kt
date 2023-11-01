
package racingcar
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun main() {
    val carMap = initializeCarMap()
    println("시도할 횟수는 몇 회인가요?")
    val numberInput = Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
    runRace(carMap, numberInput)
}

fun initializeCarMap(): MutableMap<String , Int >{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val input =Console.readLine()
    if(input.isNullOrBlank()) {
        throw IllegalArgumentException()
    }
    val cars = input.split(",").map{it.trim()}
    if (cars.any {it.length >5}) {
        throw IllegalArgumentException()
    }
    return cars.associateWithTo(mutableMapOf()) {0}
}

fun runRace (carMap: MutableMap<String, Int>, numberInput :Int ){
    println()
    println("실행 결과")

    repeat(numberInput){
        carMap.keys.forEach{ carName ->
            val updateCar = randomValue(carMap[carName] ?:0 )
            carMap[carName]=updateCar
        }
        carMap.forEach{(carName , value) ->
            println("$carName : ${"-".repeat(value)}")
        }
        println()
    }
    val maxDashe = carMap.values.max()
    val winners = carMap.filterValues { it === maxDashe }.keys.joinToString ("," )
    println("최종 우승자 : ${winners}")
}

fun randomValue(value :Int):Int {
    val randomsNumber = Randoms.pickNumberInRange(0,9)
    return  if (randomsNumber >=4) value +1 else value
}