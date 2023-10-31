package racingcar

fun main() {
    // TODO: 프로그램 구현
    val carsName = inputCarsName()
    val res = addCarsList(carsName)
    println(res)
}

fun inputCarsName() : String{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readLine().toString()
}

fun addCarsList(carsName: String) : List<String> {
    val splitResult = carsName.split(",").toList()
    return splitResult
}