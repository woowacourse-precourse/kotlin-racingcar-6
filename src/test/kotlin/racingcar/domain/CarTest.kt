package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.Exception

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("woowa")
    }

    @ParameterizedTest
    @MethodSource("provideNormalCarNameData")
    fun `차 이름 유효성 검증 (정상)`(normalData: List<String>) {
        normalData.forEach {
            assertThatCode { Car(it) }
                .doesNotThrowAnyException()
        }
    }

    @ParameterizedTest
    @MethodSource("provideErrorCarNameData")
    fun `차 이름 유효성 검증 (에러)`(errorData: List<String>) {
        errorData.forEach {
            assertThatThrownBy { Car(it) }
                .isExactlyInstanceOf(IllegalArgumentException::class.java)
                .isInstanceOf(Exception::class.java)
                .hasMessageContaining("[ERROR]")
        }
    }

    @ParameterizedTest
    @MethodSource("provideMoveData")
    fun `move 함수 검증`(randomValue: Int, expectedMove: Boolean) {
        val actualMove = car.move(randomValue)

        assertThat(actualMove).isEqualTo(expectedMove)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    fun `유효한 랜덤 값이 아닐 때(에러)`(errorData: Int) {
        assertThatThrownBy { car.move(errorData) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .isInstanceOf(Exception::class.java)
            .hasMessageContaining("[ERROR]")
    }

    companion object {
        @JvmStatic
        fun provideNormalCarNameData(): List<Arguments> = listOf(
            Arguments.of(listOf("다섯글자임", "네글자임", "세글자", "두글", "한")), // 한글
            Arguments.of(listOf("abcde", "fghi", "jkl", "mn", "o")), // 영어
            Arguments.of(listOf("12345", "6789", "012", "34", "5")), // 숫자
            Arguments.of(listOf("!@#$%", "^&*(", "^_^", "^^", "!")), // 특수문자
            Arguments.of(listOf("가a1!.", "가a1!", "가a1", "가a", "가 a !")), // 혼용
        )

        @JvmStatic
        fun provideErrorCarNameData(): List<Arguments> = listOf(
            Arguments.of(listOf("", " ", "\n")), // 문자열이 들어오지 않았을 때
            Arguments.of(listOf("가나다라마바", "abcdef")), // 5글자가 넘었을 때
            Arguments.of(listOf(" 가 나 다", "a b  c")), // 공백포함 5글자 넘었을 때
        )

        @JvmStatic
        fun provideMoveData(): List<Arguments> = listOf(
            Arguments.of(0, "false"),
            Arguments.of(3, "false"),
            Arguments.of(4, "true"),
            Arguments.of(9, "true"),
        )
    }
}