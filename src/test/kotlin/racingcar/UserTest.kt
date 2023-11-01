package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class UserTest {
    private lateinit var user: User

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

    private val testInputs = listOf(
        "pobi, woni, jun",
        "pobi,     woni, jun"
    )

    private val expectedCarsList = listOf(
        listOf(Car("pobi"), Car("woni"), Car("jun")),
        listOf(Car("pobi"), Car("woni"), Car("jun"))
    )
}