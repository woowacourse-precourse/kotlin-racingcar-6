package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

fun randomNumberGenerator(startNum: Int, lastNum: Int): Int {
    return Randoms.pickNumberInRange(startNum, lastNum)
}