package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
object RandomNumberGenerator {
    private const val minNumber = 0
    private const val maxNumber = 9

    fun run(): Int{
        return Randoms.pickNumberInRange(minNumber, maxNumber)
    }
}