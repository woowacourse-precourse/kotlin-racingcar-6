package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("RacingCar에서")
class RacingCarTest {


    @Test
    @DisplayName("random number가 4 이상이면 forwarCount가 1이 더해진다")
    fun moveWhenNumberGreaterThan3() {
        //given
        val racingCar = RacingCar("i30")
        val beforeForwardCount = racingCar.readForwardCount()
        //when
        racingCar.moveRacingCar(5)
        //then
        val afterForwardCount = racingCar.readForwardCount()
        Assertions.assertThat(afterForwardCount).isEqualTo(beforeForwardCount + 1)
    }

    @Test
    @DisplayName("random number가 4 미만이면 forwarCount가 더해지지 않는다")
    fun moveWhenNumberLessThan4() {
        //given
        val racingCar = RacingCar("i30")
        val beforeForwardCount = racingCar.readForwardCount()
        //when
        racingCar.moveRacingCar(2)
        //then
        val afterForwardCount = racingCar.readForwardCount()
        Assertions.assertThat(afterForwardCount).isEqualTo(beforeForwardCount)
    }

    @Test
    @DisplayName("생성한 초기의 forwardCount를 받을 수 있다")
    fun receiveForwardCount() {
        //given
        val racingCar = RacingCar("i30")
        //when
        val forwardCount = racingCar.readForwardCount()
        //then
        Assertions.assertThat(forwardCount).isEqualTo(0)
    }

    @Test
    @DisplayName("자동차 이름을 받을 수 있다")
    fun readRacingCarName() {
        //given
        val originCarName = "i30"
        val racingCar = RacingCar(originCarName)
        //when
        val receivedCarName = racingCar.readRacingCarName()
        //then
        Assertions.assertThat(receivedCarName).isEqualTo(originCarName)
    }
}