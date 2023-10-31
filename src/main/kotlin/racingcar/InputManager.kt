package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Constants.EXCEPTION_CAR_NAME_DUPLICATION
import racingcar.Constants.EXCEPTION_CAR_NAME_LENGTH
import racingcar.Constants.EXCEPTION_CAR_NAME_STARTS_WITH_BLANK
import racingcar.Constants.EXCEPTION_CAR_NUM
import racingcar.Constants.EXCEPTION_TRIAL_NUM
import racingcar.Constants.INPUT_NAMES
import racingcar.Constants.INPUT_TRIAL_NUM
import kotlin.IllegalArgumentException

object InputManager {

    fun getGameSettings(): GameSetting {
        println(INPUT_NAMES)
        val cars = Console.readLine()
        val carList = getCarList(cars)

        println(INPUT_TRIAL_NUM)
        val num = Console.readLine()
        val trialNum = getTrialNum(num)

        println()

        return GameSetting(carList = carList, trialNum = trialNum)
    }

    fun getCarList(names: String): List<RacingCar> {
        val nameList = names.split(",")

        if (nameList.size < 2) throw IllegalArgumentException(EXCEPTION_CAR_NUM)
        if (nameList.size != nameList.distinct().count()) throw IllegalArgumentException(EXCEPTION_CAR_NAME_DUPLICATION)

        val carList = nameList.map { carName ->
            if (carName.length > 5 || carName.isEmpty()) throw IllegalArgumentException(EXCEPTION_CAR_NAME_LENGTH)
            if (carName.startsWith(" ")) throw IllegalArgumentException(EXCEPTION_CAR_NAME_STARTS_WITH_BLANK)

            RacingCar(name = carName, moves = 0)
        }
        return carList
    }

    fun getTrialNum(num: String): Long = try {
        num.toLong()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(EXCEPTION_TRIAL_NUM)
    }
}