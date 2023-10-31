package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Validator

class ApplicationTest : NsTest() {

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
        val actual = validator.checkMoveCountValid(countOfMove)
        
        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 100을 이동 횟수 검증 함수인 checkMoveCountValid 함수에 입력하면 true를 반환한다`() {
        // given
        val countOfMove = 100

        // when
        val actual = validator.checkMoveCountValid(countOfMove)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 -1을 이동 횟수 검증 함수인 checkMoveCountValid 함수에 입력하면 false를 반환한다`() {
        // given
        val countOfMove = -1

        // when
        val actual = validator.checkMoveCountValid(countOfMove)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `pobi 이름이 조건에 맞는지 검사하면 true를 반환한다`() {
        // given
        val name = "pobi"

        // when
        val actual = validator.checkCarNameValid(name)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `123456 이름이 조건에 맞는지 검사하면 false를 반환한다`() {
        // given
        val name = "123456"

        // when
        val actual = validator.checkCarNameValid(name)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `굿이모지👍 이름이 조건에 맞는지 검사하면 true를 반환한다`() {
        // given
        val name = "굿이모지👍"

        // when
        val actual = validator.checkCarNameValid(name)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
