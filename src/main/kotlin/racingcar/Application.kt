package racingcar

val carNames = mutableListOf<String>()

fun main() {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분\n")
    val input = readLine()
    if(input!=null){
        carNames.addAll(input.split(",").map { it.trim() })
        val invalidCarNames = carNames.filter { it.length > 5 }
        if (invalidCarNames.isNotEmpty()){
            throw IllegalArgumentException("자동차의 입력값의 길이는 5이하로 입력해주세요.")
    }
    print(carNames)
}
}
