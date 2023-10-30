package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class RacingGame {

    fun randomRace():Int{
        var carNum:Int = pickNumberInRange(0,9)

        return carNum
    }
}