package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    gameStart()
    inputCarName()
}

fun gameStart() {
    println("레이싱 카 게임")
    println("=====================================")
    println("경주할 자동차 이름을 입력하세요.(영문이름은 5자까지,  쉼표(,) 기준으로 구분)")
}

fun inputCarName() {
    var inputText = ""
    var afterText = ""
    //패턴 비교후 텍스트
    val stringPattern = Regex("[^A-Za-z0-9,]")
    // 텍스트 비교용 패턴, 영문/숫자/쉼표만
    var carNameList = mutableListOf<String>()

    inputText = Console.readLine().replace(" ", "")
    //맨 왼쪽, 맨 오른쪽 공백은 편의상 제외처리

    afterText = stringPattern.replace(inputText, "")

    println("변환 전 : ${inputText}")
    println("변환 전 : ${afterText}")

    if (inputText != afterText) {
        println("여기 왔음")
        throw IllegalArgumentException()
        try {
        } catch (e: IllegalArgumentException) {
            println("잘못된 문자가 입력되어 게임종료")
            System.out
        }
    }

    carNameList = afterText.toString().split(",").toMutableList()

    print("자동차 이름은 : ")
    for ((index, value) in carNameList.withIndex()) {
        print("${value}")
        if (carNameList.size == 1) {
            break
        } else if (carNameList.size > 1) {
            print(",")
        }
    }
}
