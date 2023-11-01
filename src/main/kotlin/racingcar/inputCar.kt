package racingcar


fun inputCar(): List<String> {                              // 자동차 이름들 입력
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine()!!
    val carNames = input.split(",").map{ it.trim() } // 각 문자열 공백 제거

    carNames.forEach{
        if(it.length > 5) throw IllegalArgumentException()
    }
    return carNames
}
