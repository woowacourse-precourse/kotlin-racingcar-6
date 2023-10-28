package racingcar

val carNames = mutableListOf<String>()

fun main() {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분\n")
    val input = readLine()
    if(input!=null){
        carNames.addAll(input.split(",").map { it.trim() }
        )
    }
    print(carNames)
}
