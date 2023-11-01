package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test

class ValidatorTest {

    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = Validator()
    }

    @Test
    fun `숫자 0을 이동 횟수 검증 함수인 checkMoveCountValid 함수에 입력하면 true를 반환한다`() {
        // given
        val countOfMove = 0

        // when
        val actual = validator.checkMoveCount(countOfMove)

        // then
        val expected = true
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 100을 이동 횟수 검증 함수인 checkMoveCountValid 함수에 입력하면 true를 반환한다`() {
        // given
        val countOfMove = 100

        // when
        val actual = validator.checkMoveCount(countOfMove)

        // then
        val expected = true
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 -1을 이동 횟수 검증 함수인 checkMoveCountValid 함수에 입력하면 false를 반환한다`() {
        // given
        val countOfMove = -1

        // when
        val actual = validator.checkMoveCount(countOfMove)

        // then
        val expected = false
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `pobi 이름이 조건에 맞는지 검사하면 true를 반환한다`() {
        // given
        val name = "pobi"

        // when
        val actual = validator.checkCarName(name)

        // then
        val expected = true
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `123456 이름이 조건에 맞는지 검사하면 false를 반환한다`() {
        // given
        val name = "123456"

        // when
        val actual = validator.checkCarName(name)

        // then
        val expected = false
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `굿이모지👍 이름이 조건에 맞는지 검사하면 true를 반환한다`() {
        // given
        val name = "굿이모지👍"

        // when
        val actual = validator.checkCarName(name)

        // then
        val expected = true
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}