package racingcar

import camp.nextstep.edu.missionutils.*

fun main() {
    // TODO: 프로그램 구현

    var car: String = getCarName()
    var carList = separationCarName(car)
    var carCount: Int = carList.size;

    nameLengthCheck(carCount, carList)

    var gameCount: Int = inputPlayCount()
    var carGoCount = carGoCountList(carCount)

    println("실행 결과")
    repeat(gameCount) {
        playGame(carCount, carGoCount, carList, carCount)
    }


    var MAX = 0;
    for (i in 0..carCount - 1) {
        if (carGoCount.get(i) > MAX) {
            MAX = carGoCount.get(i);
        }
    }

    val answer = ArrayList<String>()
    print("최종 우승자 : ")

    for (i in 0..carCount - 1) {
        if (carGoCount.get(i) == MAX && answer.isEmpty()) {
            answer.add(carList.get(i))
            print(carList.get(i))
        } else if (carGoCount.get(i) == MAX) {
            print(", " + carList.get(i))
        }
    }

}

fun getCarName(): String { // 자동차 이름 입력 받기
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var getCarName = Console.readLine();
    return getCarName
}

fun inputPlayCount(): Int { // 시도할 횟수 입력 받기
    println("시도할 횟수는 몇 회인가요?")
    var inputCount = Console.readLine().toInt();
    return inputCount
}

fun separationCarName(input: String): List<String> { // 자동차 이름 분리
    var carList: List<String> = input.split(",")
    return carList;
}

fun nameLengthCheck(input1: Int, input2: List<String>) { // 자동차 이름 길이 초과 여부 확인
    for (i in 0..input1 - 1) {
        var temp = input2.get(i)
        if (temp.length >= 5) {
            inputError()
        }
    }
}

fun randomNumber(): Int { // 난수 생성 (0~9)
    var randomNumber = Randoms.pickNumberInRange(0, 9)
    return randomNumber
}

fun carGoCountList(count: Int): MutableList<Int> { // 자동차 전진 횟수 저장 리스트 생성
    val carGoCount: MutableList<Int> = MutableList<Int>(count, { i -> i })
    for (i in 0..count - 1) {
        carGoCount.set(i, 0);
    }
    return carGoCount
}

fun playGame(input1: Int, carGoCount: MutableList<Int>, carList: List<String>, carCount: Int) { // 게임 실행
    for (i in 0..input1 - 1) {
        var choiceGo: Int = randomNumber()
        if (choiceGo >= 4 && choiceGo <= 9) {
            var countNow = carGoCount.get(i)
            countNow++
            carGoCount.set(i, countNow)
        }

        print(carList.get(i) + " : ")
        var temp: Int = carGoCount.get(i) - 1
        for (j in 0..temp) {
            print("-")
        }
        println()
        if (i == carCount - 1) {
            println()
        }
    }
}

fun inputError() {
    throw IllegalArgumentException("오류 발생 예외처리 : 자동차 이름 제한 길이 초과");
}