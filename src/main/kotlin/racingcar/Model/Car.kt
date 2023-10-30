package racingcar.Model

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var distance: Int = 0) { // 각각의 자동차의 상태, 행동을 정의.

    fun moveCar() { // 차 움직이는 함수
        val randomNumber = Randoms.pickNumberInRange(0, 9) // 0 ~ 9 까지의 무작위의 숫자로 움직일 수 있음.
        if(randomNumber >= 4) { // 전진하는 조건 -> 무작위 값이 4 이상.
            distance++
        }
    }

    fun fetchDistance(): Int { // 거리 확인하는 함수
        return distance
    }
}