package racingcar
import camp.nextstep.edu.missionutils.Randoms


fun randomValue() : Int{                                    // 전진 랜덤수 0 ~ 9
    var randNum = Randoms.pickNumberInRange(0,9)
    return randNum
}