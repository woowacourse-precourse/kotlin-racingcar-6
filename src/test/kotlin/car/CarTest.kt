package car

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarTest {
    @Test
    fun `자동차가 전진하는지 테스트`() {
        val car = Car("test")

        car.move()
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            Assertions.assertThat(car.getPosition()).isEqualTo(1)
        }
        if (Randoms.pickNumberInRange(0, 9) < 4){
            Assertions.assertThat(car.getPosition()).isEqualTo(0)
        }
    }


}