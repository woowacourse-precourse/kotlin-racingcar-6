package racingcar.data

import camp.nextstep.edu.missionutils.Randoms

object CarFactory {
    fun makeCarList(playerList: List<String>, gameCount: Int): List<Car> =
        playerList.map { Car(it, makeRandomList(gameCount)) }

    private fun makeRandomList(count: Int): List<CarState> =
        (1..count).map { Randoms.pickNumberInRange(0, 9) }.map { CarState.toCarState(it) }
}