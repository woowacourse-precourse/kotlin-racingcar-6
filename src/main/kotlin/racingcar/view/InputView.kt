package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.Car
import racingcar.utils.TypeConverter.stringToCarList
import racingcar.utils.TypeConverter.stringToInt

object InputView {

    private const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val INPUT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"

    fun inputCarNames(): List<Car> {
        println(INPUT_CAR_NAMES)
        return stringToCarList(Console.readLine())
    }

    fun inputRoundCount(): Int {
        println(INPUT_ROUND_COUNT)
        return stringToInt(Console.readLine())
    }
}