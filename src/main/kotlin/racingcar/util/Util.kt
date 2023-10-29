package racingcar.util

object Util {

    fun getCarNames(): List<String> {
        val input = camp.nextstep.edu.missionutils.Console.readLine()

        val carNames = splitCarName(input)

        for (name in carNames) checkCarName(name)

        return carNames

    }

    fun splitCarName(input : String) : List<String> {
        return input.split(',')
    }

    fun checkCarName(name : String) {
        if(name.length > 5) throw IllegalArgumentException("이름은 5자 이하만 가능합니다.")
    }
}