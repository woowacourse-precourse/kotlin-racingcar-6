package racingcar

// import camp.nextstep.edu.missionutils.Randoms //pickNumberInRange
// import camp.nextstep.edu.missionutils.Console //readLine

fun main() {
    
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val inputNames = readLine()
    val nameList = inputNames?.split(",") 
    val carMap = mutableMapOf<String, Int>()
    
    for (name in nameList!!) {
        if (name.trim().length <= 5) {
            carMap.put(name.trim(), 0)
        } else {
            throw IllegalArgumentException()
        }
    }
    
    println("시도할 횟수는 몇 회인가요?")
    
    val moveConut = readLine()
    
    
}
