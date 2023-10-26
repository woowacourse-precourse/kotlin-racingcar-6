package racingcar
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.")
    val carNames = readLine().split(',')
    val carNamesAndResults = mutableMapOf<String, String>()
    for (i in carNames)
        carNamesAndResults[i] = ""
//    for (i in carNamesAndResults)
//        println(i)
    //print(carNamesAndResults)
}
