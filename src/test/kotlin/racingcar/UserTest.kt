package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

class UserTest {
    private lateinit var user: User
    private val testInputs = listOf(
        "pobi, woni, jun",
        "pobi,     woni, jun"
    )

    private val expectedCarsList = listOf(
        listOf(Car("pobi"), Car("woni"), Car("jun")),
        listOf(Car("pobi"), Car("woni"), Car("jun"))
    )

    @BeforeEach
    fun setUp() {
        user = User()
    }

    @TestFactory
    fun `차들이 올바르게 생성된 경우`() = testInputs.mapIndexed { index, testInput ->
        dynamicTest("테스트 케이스 ${index + 1}") {
            val cars = user.createCars(testInput)
            val expectedCars = expectedCarsList[index]

            val result = cars.zip(expectedCars) { actual, expected ->
                actual.name == expected.name
            }.all { it }

            assertThat(result).isTrue()
        }
    }

    @Test
    fun `입력값이 올바르지 않은 경우 예외를 발생시켜야 함`() {
        val input = "pobi, wodjsss, jun"
        val exception = assertThrows<IllegalArgumentException> { user.createCars(input) }

        assertThat(exception.message).isEqualTo("자동차 이름은 ${MAX_NAME_LENGTH}자 이하로 입력해주세요.")
    }
}