package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputHandlerTest {

    @Nested
    @DisplayName("차 이름 입력 테스트")
    inner class CarNameTest{
        @ParameterizedTest
        @ValueSource(strings = ["honda", "toyo", "bmw"])
        fun `차이름 모든 입력값이 알파벳 소문자`(carName: String) {
            assertTrue(InputHandler.isValidCarName(listOf(carName)))
        }

        @ParameterizedTest
        @ValueSource(strings = ["Ford", "Nissan", "Audi"])
        fun `차이름 입력값에 알파벳 대문자 포함`(carName: String) {
            assertFalse(InputHandler.isValidCarName(listOf(carName)))
        }

        @ParameterizedTest
        @ValueSource(strings = ["ford1", "Nissan", "Audi"])
        fun `차이름 입력값에 숫자 포함`(carName: String) {
            assertFalse(InputHandler.isValidCarName(listOf(carName)))
        }


    }

    @Nested
    @DisplayName("횟수 입력 테스트")
    inner class AmountTest {
        @ParameterizedTest
        @ValueSource(strings = ["12c"])
        fun `횟수 입력값에 숫자가 아닌 값 포함`(amount: String) {
            assertFalse(InputHandler.isValidAmount(amount.toIntOrNull()))
        }

        @ParameterizedTest
        @ValueSource(strings = ["1", "2", "3"])
        fun `횟수 입력값에 자연수만 포함`(amount: String) {
            assertTrue(InputHandler.isValidAmount(amount.toInt()))
        }
    }


    
    


}