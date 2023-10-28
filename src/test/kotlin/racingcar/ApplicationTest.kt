package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.assertThrows
import racingcar.domain.IOHandler
import racingcar.domain.Validator
import java.io.ByteArrayInputStream

class ApplicationTest : NsTest() {

    private lateinit var validator: Validator
    private lateinit var ioHandler: IOHandler

    @BeforeEach
    fun setUp() {
        validator = Validator()
        ioHandler = IOHandler(validator)
    }

    @AfterEach
    fun tearDown() {
        Console.close()
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
    fun `ppoBi,영수,철수를 자동차 이름으로 입력하면 ppoBi와 영수와 철수로 된 list를 반환한다`() {
        // given
        val names = "ppoBi,영수,철수"
        setInput(names)

        // when
        val actual = ioHandler.getCarName()

        // then
        val expected = listOf("ppoBi", "영수", "철수")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `가"나"다를 자동차 이름으로 입력하면 가"나"다로 된 list를 반환한다`() {
        // given
        val name = "가\"나\"다"
        setInput(name)

        // when
        val actual = ioHandler.getCarName()

        // then
        val expected = listOf("""가"나"다""")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `line break 문자열을 포함한 자동차 이름을 입력하면 line break이 포함된 list를 반환한다`() {
        // given
        val name = "이\\n름, 정상이름"
        setInput(name)

        // when
        val actual = ioHandler.getCarName()

        // then
        val expected = listOf("이\\n름", " 정상이름")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `빈 문자열을 자동차 이름으로 입력하면 IllegalArgumentException이 발생한다`() {
        // given
        val name = "\n"
        setInput(name)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getCarName()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = "문자열 길이가 1 ~ 5에 속하지 않습니다."
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedErrorMessage)

    }

    @Test
    fun `"  "을 자동차 이름으로 입력하면 " "를 리턴한다`() {
        // given
        val name = "  "
        setInput(name)

        // when
        val actual = ioHandler.getCarName()

        // then
        val expected = listOf("  ")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `"김 치"를 자동차 이름으로 입력하면 "김 치"를 리턴한다`() {
        // given
        val name = "김 치"
        setInput(name)

        // when
        val actual = ioHandler.getCarName()

        // then
        val expected = listOf("김 치")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `"김 치 "를 자동차 이름으로 입력하면 "김 치 "를 리턴한다`() {
        // given
        val name = "김 치 "
        setInput(name)

        // when
        val actual = ioHandler.getCarName()

        // then
        val expected = listOf("김 치 ")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `" ,   ,  "를 자동차 이름으로 입력하면 " ", "   ","  "를 리턴한다`() {
        // given
        val name = " ,   ,  "
        setInput(name)

        // when
        val actual = ioHandler.getCarName()

        // then
        val expected = listOf(" ", "   ", "  ")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `",  , "를 자동차 이름으로 입력하면 IllegalArgumentException이 발생한다`() {
        // given
        val names = ",  , "
        setInput(names)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getCarName()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = "문자열 길이가 1 ~ 5에 속하지 않습니다."
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `중복된 이름을 입력할 수 있다`() {
        // given
        val names = "아우디, 아우지,아우디"
        setInput(names)

        // when
        val actual = ioHandler.getCarName()

        // then
        val expected = listOf("아우디", " 아우지", "아우디")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `이동 횟수 5를 입력 받는다`() {
        // given
        val input = "5"
        val result = 5

        // when

        // then
    }

    @Test
    fun `이동 횟수로 숫자가 아닌 다른 값을 입력 받으면 예외를 발생시킨다`() {
        // given
        val input = "열 번"
        // throw IllegalArgumentException

        // when

        // then
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

    private fun setInput(input: String) {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
