package racingcar.util

import racingcar.model.RacingCar

object Util {

    //자동차들의 이름을 list로 얻는 함수
    fun getCarNames(): List<String> {
        val input = camp.nextstep.edu.missionutils.Console.readLine()

        val carNames = splitCarName(input)

        for (name in carNames) checkCarName(name)

        return carNames

    }

    fun splitCarName(input: String): List<String> {
        return input.split(',')
    }

    fun checkCarName(name: String) {
        if (name.length > 5) throw IllegalArgumentException("이름은 5자 이하만 가능합니다.")
    }

    //자동차 경주를 시도할 횟수 얻기
    fun getPlayCount(): Int? {
        val playCountString = camp.nextstep.edu.missionutils.Console.readLine()

        val playCount = stringToInt(playCountString)

        checkInt(playCount)

        camp.nextstep.edu.missionutils.Console.close()

        return playCount

    }

    fun stringToInt(string: String): Int? {
        return string.toIntOrNull()
    }

    fun checkInt(int: Int?) {
        if (int == null) throw IllegalArgumentException("양의 정수를 입력해주세요.")
    }

    // 우승자(들)을 list에 저장하는 함수
    fun findWinner(cars:MutableList<RacingCar>) : MutableList<RacingCar>{
        val winners = mutableListOf<RacingCar>()

        val maxCount = cars.maxOfOrNull { it.forwardCount }

        if (maxCount != null) {
            winners.addAll(cars.filter { it.forwardCount == maxCount })
        }

        return winners
    }

}