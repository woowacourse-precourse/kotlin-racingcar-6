package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("RacingCar에서")
class RacingCarTest {

    private val racingCar = RacingCar("i30")

    @Test
    @DisplayName("forwardCount를 증가시키면 1이 더해진다")
    fun addForwardCount() {
        //given
        val beforeForwardCount = racingCar.receiveForwardCount()
        //when
        racingCar.addForwardCount()
        //then
        val afterForwardCount = racingCar.receiveForwardCount()
        Assertions.assertThat(afterForwardCount).isEqualTo(beforeForwardCount + 1)
    }

    @Test
    @DisplayName("생성한 초기의 forwardCount를 받을 수 있다")
    fun receiveForwardCount() {
        //given
        //when
        val forwardCount = racingCar.receiveForwardCount()
        //then
        Assertions.assertThat(forwardCount).isEqualTo(0)
    }

    @Test
    @DisplayName("자동차 이름을 받을 수 있다")
    fun readRacingCarName() {
        //given
        //when
        val carName = racingCar.readRacingCarName()
        //then
        Assertions.assertThat(carName).isEqualTo("i30")
    }
}