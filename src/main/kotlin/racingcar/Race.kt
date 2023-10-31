package racingcar

import camp.nextstep.edu.missionutils.Console

class Race {
    fun inputData(){
        println("경주할 자동차 이름 입력해주세요 ")
        Process.generateCars(Console.readLine())
        println("시도할 횟수는?")
        Process.setAttemptTimes(Console.readLine())
        Process.getRound()
    }

    fun play() {
        Process.playRound()
    }
}