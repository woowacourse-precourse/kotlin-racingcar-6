package myTest

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.RacingGame


class carMoveTest {
    @Test
    fun `다섯 라운드를 진행했을 때 최고 이동한 사람이 맞는지 확인`() {
        val carNameList = listOf("test1", "test2", "test3")
        val tryCount = 5

        val racing = RacingGame(carNameList, tryCount)

        val result = racing.runRacingGame().split(", ")

        val winnerList = ArrayList<String>()
        for (item in racing.carList) {
            if (racing.racingGame[item] == racing.winnerPos) {
                winnerList.add(item)
            }
        }

        for (winner in winnerList) {
            assertThat(result).contains(winner)
        }

    }
}