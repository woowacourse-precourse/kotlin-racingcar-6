package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing {


    //true 면 move, false면 stop
    private fun determineMoveOrStop(randomNumber:Int) = randomNumber>= BASE_NUMBER
    private fun makeRandomNumber() = Randoms.pickNumberInRange(0, 9)
}