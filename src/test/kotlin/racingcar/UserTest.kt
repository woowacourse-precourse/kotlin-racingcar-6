package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.User
import java.util.stream.Stream

class UserTest {
    companion object {
        @JvmStatic
        fun provideCarNamesForValidation(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(",,,,", "자동차의 이름이 입력되지 않았습니다."),
                Arguments.of("car123456,car2", "자동차 이름은 5자 이하이어야 합니다."),
                Arguments.of("car1,car1,car3", "자동차 이름은 중복될 수 없습니다.")
            )
        }

        @JvmStatic
        fun provideAttemptNumbersForValidation(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("0", "시도 횟수는 양의 정수이어야 합니다."),
                Arguments.of("-1", "시도 횟수는 양의 정수이어야 합니다."),
                Arguments.of("abc", "유효하지 않은 입력입니다. 양의 정수를 입력해주세요."),
                Arguments.of("1.5", "유효하지 않은 입력입니다. 양의 정수를 입력해주세요.")
            )
        }
    }

    private val user = User()

    @ParameterizedTest
    @MethodSource("provideCarNamesForValidation")
    fun `validateNames에서 예외사항 테스트`(input: String, expectedMessage: String) {
        val exception = assertThrows<IllegalArgumentException> {
            user.validateNames(input)
        }
        assertEquals(expectedMessage, exception.message)
    }

    @ParameterizedTest
    @MethodSource("provideAttemptNumbersForValidation")
    fun `validateAttemptNumber tests`(input: String, expectedMessage: String) {
        val user = User()

        val exception = assertThrows<IllegalArgumentException> {
            user.validateAttemptNumber(input)
        }
        assertEquals(expectedMessage, exception.message)
    }

}