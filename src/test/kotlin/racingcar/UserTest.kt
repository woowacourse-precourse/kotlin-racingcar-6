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
        "pobi",
        "pobi, woni",
        "pobi, woni, jun",
    )

    private val expectedCarsList = listOf(
        listOf(Car("pobi")),
        listOf(Car("pobi"), Car("woni")),
        listOf(Car("pobi"), Car("woni"), Car("jun"))
    )

    private val incorrectTestInputs = listOf(
        "",
        ", abc, a",
        "abc, a,",
        "abc,, a",
        ",",
        ", abc, a,",
        "abcdef",
        "a, bcdefg, h"
    )

    @BeforeEach
    fun setUp() {
        user = User()
    }

    @TestFactory
    fun `차들이 올바르게 생성된 경우`() = testInputs.mapIndexed { index, input ->
        dynamicTest("테스트 케이스 ${index + 1}") {
            val cars = user.createCars(input)
            val expectedCars = expectedCarsList[index]

            val result = cars.zip(expectedCars) { actual, expected ->
                actual.name == expected.name
            }.all { it }

            assertThat(result).isTrue()
        }
    }

    @TestFactory
    fun `잘못된 입력에 대해 차들을 생성하지 못하는 예외를 발생시켜야 함`() = incorrectTestInputs.mapIndexed { index, input ->
        dynamicTest("테스트 케이스 ${index + 1}") {
            assertThrows<IllegalArgumentException> { user.createCars(input) }
        }
    }
}