package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.Randoms
import racingcar.res.CarMovement.MOVING_FORWARD
import racingcar.res.CarMovement.MOVING_FORWARD_RECORD
import racingcar.res.CarMovement.STOP
import racingcar.res.CarMovement.STOP_RECORD

class CarTest {
  private lateinit var myCar: Car

  @BeforeEach
  fun setUp() {
    myCar = Car("neo")
  }

  @Test
  fun `moveOrNot 메서드 테스트 - 무작위 값이 4 미만일 경우 STOP`() {
    val input = Randoms.pickNumberInRange(0, 3)
    val result = myCar.moveOrNot(input)

    assertThat(myCar.record).isEqualTo(STOP_RECORD)
    assertThat(result).isEqualTo(STOP)
  }

  @Test
  fun `moveOrNot 메서드 테스트 - 무작위 값이 4 이상일 경우 GO`() {
    val input = Randoms.pickNumberInRange(4, 9)
    val result = myCar.moveOrNot(input)

    assertThat(myCar.record).isEqualTo(MOVING_FORWARD_RECORD)
    assertThat(result).isEqualTo(MOVING_FORWARD)
  }
}