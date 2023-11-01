package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

class UserTest {
    private lateinit var user: User
    private val testInputs = listOf(
        "pobi",
        "pobi, woni",
        "pobi, woni, jun",
        "pobi,woni,jun,john",
        "pobi, woni,  jun,john, tom  "
    )

    private val expectedCarNamesList = listOf(
        listOf("pobi"),
        listOf("pobi", "woni"),
        listOf("pobi", "woni", "jun"),
        listOf("pobi", "woni", "jun", "john"),
        listOf("pobi", "woni", "jun", "john", "tom")
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
    fun `입력값에 대해 차들이 올바르게 생성된 경우 성공`() = testInputs.mapIndexed { index, input ->
        dynamicTest("테스트 케이스 ${index + 1}") {
            val expectedCarNames = expectedCarNamesList[index]

            val actualCarNames = user.createCars(input).map { it.name }

            assertThat(actualCarNames).isEqualTo(expectedCarNames)
        }
    }

    @TestFactory
    fun `잘못된 입력에 대해 차들을 생성하지 못하는 예외를 발생시켜야 함`() = incorrectTestInputs.mapIndexed { index, input ->
        dynamicTest("테스트 케이스 ${index + 1}") {
            assertThrows<IllegalArgumentException> { user.createCars(input) }
        }
    }
}