package racingcar.Car

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Move

private const val MiN_RANDOM_VALUE = 0
private const val MAX_RANDOM_VALUE = 9
private const val MIN_MOVE_VALUE = 4

class Car {

    @Test
    fun `moveOrStay 함수는 MIN_MOVE_VALUE 이상의 난수가 주어지면 차량을 이동시켜야 한다`() {
        val car = Car("test")

        val randomNumber = Randoms.pickNumberInRange(MiN_RANDOM_VALUE, MAX_RANDOM_VALUE)
        if (randomNumber >= MIN_MOVE_VALUE) {
            Move.moveOrStay(car)
            Assertions.assertThat(car.position).isNotEqualTo(0) // 차량이 이동했는지 확인
        } else {
            Move.moveOrStay(car)
            Assertions.assertThat(car.position).isZero() // 차량이 그대로 남아있는지 확인
        }
    }
}