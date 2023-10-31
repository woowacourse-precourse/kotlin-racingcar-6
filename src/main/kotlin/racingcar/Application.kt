package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var carNameList = mutableListOf<String>()
    var inputCount = 0

    gameStart()
    carNameList = inputCarName()
    inputCount = inputRoundCount()
    racingPlay(carNameList, inputCount)
}

fun gameStart() {
    println("레이싱 카 게임")
    println("=====================================")
    println("경주할 자동차 이름을 입력하세요.(영문이름은 5자까지,  쉼표(,) 기준으로 구분)")
}

fun inputCarName(): MutableList<String> {
    var inputText = ""
    var afterText = ""
    //패턴 비교후 텍스트
    val stringPattern = Regex("[^A-Za-z0-9,]")
    // 텍스트 비교용 패턴, 영문/숫자/쉼표만, 이름중복 때문에 숫자 허용, 5자 제한 & 중복일 경우 추가처리 필요
    // 끝자리 쉼표만 있는경우 처리필요

    inputText = Console.readLine().replace(" ", "")
    //맨 왼쪽, 맨 오른쪽 공백은 편의상 제외처리
    afterText = stringPattern.replace(inputText, "")

    println("변환 전 : ${inputText}")
    println("변환 후 : ${afterText}")

    if (inputText != afterText) {
        throw IllegalArgumentException()
        // 예외발생후 처리 안됨 버그수정필요
        try {
        } catch (e: IllegalArgumentException) {
            println("잘못된 문자가 입력되어 게임종료")
            System.out
        }
    }

    var carNameList = afterText.toString().split(",").toMutableList()

    print("자동차 이름은 : ")
    for ((index, value) in carNameList.withIndex()) {
        print("${value}")
        if (carNameList.size == 1) {
            break
            // 자동차 이름이 1개만 있을때 처리필요
        } else if (carNameList.size > 1) {
            print(",")

        }
    }
    return carNameList
}

fun inputRoundCount(): Int {
    var inputCount = 0
    print("진행할 라운드 횟수 입력(최대 10) : ")

    try {
        inputCount = Console.readLine().replace(" ", "").toInt()
    } catch (e: IllegalArgumentException) {
        println("숫자가 아닌 문자가 입력되어 게임종료")
        System.out
    }

    if (inputCount < 1 || inputCount > 10) {
        throw IllegalArgumentException()
        // 예외발생후 처리 안됨 버그수정필요
        try {
        } catch (e: IllegalArgumentException) {
            println("해당 범위가 아닌 숫자가 입력되어 게임종료")
            System.out
        }
    }
    return inputCount
}

fun racingPlay(carNameList: MutableList<String>, inputCount: Int) {
    var racingResultList = mutableMapOf<String, String>()
    var racingProgress = ""

    for (carName in carNameList) {
        racingResultList.put(carName, racingProgress)
        // 레이싱 결과리스트 Map을 임시로 채워둠
    }


    for (i in 1..inputCount) {
        println("")
        println("[${i} 라운드]")
        for (carName in carNameList) {
            racingProgress = racingResultList[carName].toString()
            // 진행상태를 누적할 수 있도록, 결과리스트에 저장되어있던 값을 변수에 다시 저장
            racingProgress += getRanmdomNumber()
            println("--------------------------")
            println("${carName} : ${racingProgress}")
            racingResultList.put(carName, racingProgress)
            racingProgress = ""
        }
    }
}

fun getRanmdomNumber(): String {
    var racingProgress = ""
    // 레이싱 진행상황 게이지바
    var randomNumber = 0
    randomNumber = Randoms.pickNumberInRange(0, 9)

    if (randomNumber >= 4) {
        racingProgress += "-"
    } else {
        racingProgress += ""
    }
    return racingProgress
}



