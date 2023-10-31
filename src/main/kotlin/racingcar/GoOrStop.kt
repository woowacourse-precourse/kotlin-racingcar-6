package racingcar
import camp.nextstep.edu.missionutils.Randoms

class GoOrStop {
    fun goOrStop(): Int {
        var cnt = 0
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            cnt++
        return cnt
    }
}