package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.domain.CarListBuilder
import racingcar.domain.attemptValidation
import racingcar.model.Car

class ValidationTest {

    companion object {
        const val userInput = "pobi,woni,jun"
        const val userInputWithSpace = " pobi, woni, jun "

        val expected = listOf(
            Car("pobi", 0),
            Car("woni", 0),
            Car("jun", 0)
        )
    }

    @Test
    fun `사용자의 입력에 대한 정상적인 자동차 리스트인가`() {
        val received = CarListBuilder.userInputToCarList(userInput)
        Assertions.assertThat(received).isEqualTo(expected)
    }

    @Test
    fun `사용자의 입력에 공백이 있을 때 정상적인 자동차 리스트인가`() {
        val received = CarListBuilder.userInputToCarList(userInputWithSpace)
        Assertions.assertThat(received).isEqualTo(expected)
    }

    @Test
    fun `사용자가 빈 값 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            CarListBuilder.userInputToCarList("")
        }
    }

    @Test
    fun `사용자가 자동차의 이름을 6자 이상으로 설정`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            CarListBuilder.userInputToCarList("mySpecialCar,apple")
        }
    }

    @Test
    fun `사용자가 중복된 이름 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            CarListBuilder.userInputToCarList("apple,apple")
        }
    }

    @Test
    fun `사용자가 정수가 아닌 시도 횟수 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "!!".attemptValidation()
            "cat".attemptValidation()
            "0".attemptValidation()
            "-1123".attemptValidation()
            " ".attemptValidation()
        }
    }
}