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
import racingcar.data.Car
import racingcar.domain.Analyzer
import racingcar.domain.IOHandler
import racingcar.domain.Validator
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ApplicationTest : NsTest() {

    private lateinit var validator: Validator
    private lateinit var ioHandler: IOHandler
    private lateinit var anaylazer: Analyzer
    private val standardOut = System.out

    @BeforeEach
    fun setUp() {
        validator = Validator()
        ioHandler = IOHandler(validator)
        anaylazer = Analyzer()
    }

    @AfterEach
    fun tearDown() {
        Console.close()
        System.setOut(standardOut)
    }

    @Test
    fun `숫자 0이 나오면 움직일 수 없다는 의미의 false를 반환한다`() {
        // given
        val pickedNum = 0

        // when
        val actual = anaylazer.isMoveAllowed(pickedNum)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 3이 나오면 움직일 수 없다는 의미의 false를 반환한다`() {
        // given
        val pickedNum = 3

        // when
        val actual = anaylazer.isMoveAllowed(pickedNum)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 4가 나오면 움직일 수 있다는 의미의 true를 반환한다`() {
        // given
        val pickedNum = 4

        // when
        val actual = anaylazer.isMoveAllowed(pickedNum)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 9가 나오면 움직일 수 있다는 의미의 true를 반환한다`() {
        // given
        val pickedNum = 9

        // when
        val actual = anaylazer.isMoveAllowed(pickedNum)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `3칸 전진한 A, 2칸 전진한 B, 0칸 전진한 C를 입력하면 A를 승자로 반환한다`() {
        // given
        val a = Car("A")
        repeat(3) {
            a.move()
        }
        val b = Car("B")
        repeat(2) {
            b.move()
        }
        val c = Car("C")
        val candidates = listOf(a, b, c)

        // when
        val actual = anaylazer.judgeWinner(candidates)

        // then
        val expected = listOf(a)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `0칸 전진한 A, 3칸 전진한 B, 2칸 전진한 C를 입력하면 B를 승자로 반환한다`() {
        // given
        val a = Car("A")
        val b = Car("B")
        repeat(3) {
            b.move()
        }
        val c = Car("C")
        repeat(2) {
            c.move()
        }
        val candidates = listOf(a, b, c)

        // when
        val actual = anaylazer.judgeWinner(candidates)

        // then
        val expected = listOf(b)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `2칸 전진한 A, 0칸 전진한 B, 3칸 전진한 C를 입력하면 C를 승자로 반환한다`() {
        // given
        val a = Car("A")
        repeat(2) {
            a.move()
        }
        val b = Car("B")
        val c = Car("C")
        repeat(3) {
            c.move()
        }
        val candidates = listOf(a, b, c)

        // when
        val actual = anaylazer.judgeWinner(candidates)

        // then
        val expected = listOf(c)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `2칸 전진한 A, 0칸 전진한 B, 2칸 전진한 C를 입력하면 A, C를 승자로 반환한다`() {
        // given
        val a = Car("A")
        repeat(2) {
            a.move()
        }
        val b = Car("B")
        val c = Car("C")
        repeat(2) {
            c.move()
        }
        val candidates = listOf(a, b, c)

        // when
        val actual = anaylazer.judgeWinner(candidates)

        // then
        val expected = listOf(a, c)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `0칸 전진한 A, 0칸 전진한 B, 0칸 전진한 C를 입력하면 A, B, C를 승자로 반환한다`() {
        // given
        val a = Car("A")
        val b = Car("B")
        val c = Car("C")
        val candidates = listOf(a, b, c)

        // when
        val actual = anaylazer.judgeWinner(candidates)

        // then
        val expected = listOf(a, b, c)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `2칸 전진한 A, 0칸 전진한 B, 3칸 전진한 C의 현재 위치를 보여준다`() {
        // given
        val a = Car("A")
        repeat(2) {
            a.move()
        }
        val b = Car("B")
        val c = Car("C")
        repeat(3) {
            c.move()
        }
        val candidates = listOf(a, b, c)
        val outputStream = ByteArrayOutputStream()
        setOutput(outputStream)

        // when
        ioHandler.showLocation(candidates)
        val actual = outputStream.toString().replace("\r\n", "\n")

        // then
        val expected = """
            A : --
            B : 
            C : ---
            
        """.trimIndent()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `0칸 전진한 A, 0칸 전진한 B, 0칸 전진한 C의 현재 위치를 보여준다`() {
        // given
        val a = Car("A")
        val b = Car("B")
        val c = Car("C")
        val candidates = listOf(a, b, c)
        val outputStream = ByteArrayOutputStream()
        setOutput(outputStream)

        // when
        ioHandler.showLocation(candidates)
        val actual = outputStream.toString().replace("\r\n", "\n")

        // then
        val expected = """
            A : 
            B : 
            C : 
            
        """.trimIndent()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `우승자 A를 보여준다`() {
        // given
        val a = Car("A")
        val winner = listOf(a)

        val outputStream = ByteArrayOutputStream()
        setOutput(outputStream)

        // when
        ioHandler.showWinner(winner)
        val actual = outputStream.toString().replace("\r\n", "\n")

        // then
        val expected = "최종 우승자 : A"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `우승자 A, B를 보여준다`() {
        // given
        val a = Car("A")
        val b = Car("B")
        val winner = listOf(a, b)

        val outputStream = ByteArrayOutputStream()
        setOutput(outputStream)

        // when
        ioHandler.showWinner(winner)
        val actual = outputStream.toString().replace("\r\n", "\n")

        // then
        val expected = "최종 우승자 : A, B"
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
    fun `ppoBi,영수,철수를 자동차 이름으로 입력하면 ppoBi와 영수와 철수로 된 list를 반환한다`() {
        // given
        val names = "ppoBi,영수,철수"
        setInput(names)

        // when
        val actual = ioHandler.getCarNames()

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
        val actual = ioHandler.getCarNames()

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
        val actual = ioHandler.getCarNames()

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
            ioHandler.getCarNames()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.NAME_LENGTH_IS_NOT_MATCHED
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedErrorMessage)

    }

    @Test
    fun `"  "을 자동차 이름으로 입력하면 " "를 리턴한다`() {
        // given
        val name = "  "
        setInput(name)

        // when
        val actual = ioHandler.getCarNames()

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
        val actual = ioHandler.getCarNames()

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
        val actual = ioHandler.getCarNames()

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
        val actual = ioHandler.getCarNames()

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
            ioHandler.getCarNames()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.NAME_LENGTH_IS_NOT_MATCHED
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `중복된 이름을 입력할 수 있다`() {
        // given
        val names = "아우디, 아우지,아우디"
        setInput(names)

        // when
        val actual = ioHandler.getCarNames()

        // then
        val expected = listOf("아우디", " 아우지", "아우디")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `이동 횟수로 5를 입력 받으면 5를 리턴한다`() {
        // given
        val input = "5"
        setInput(input)

        // when
        val actual = ioHandler.getMoveCount()

        // then
        val expected = 5
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `이동 횟수로 "열 번"을 입력 받으면 예외를 발생시킨다`() {
        // given
        val input = "열 번"
        setInput(input)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getMoveCount()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.INPUT_IS_NOT_NUM
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `이동 횟수로 "12삼4"를 입력 받으면 예외를 발생시킨다`() {
        // given
        val input = "12삼4"
        setInput(input)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getMoveCount()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.INPUT_IS_NOT_NUM
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `이동 횟수로 "-1"을 입력 받으면 예외를 발생시킨다`() {
        // given
        val input = "-1"
        setInput(input)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getMoveCount()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.NOT_ALLOWED_COUNT
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `이동 횟수로 "0"을 입력 받으면 0을 리턴한다`() {
        // given
        val input = "0"
        setInput(input)

        // when
        val actual = ioHandler.getMoveCount()

        // then
        val expected = 0
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `이동 횟수로 "1,000,000"을 입력 받으면 1,000,000을 리턴한다`() {
        // given
        val input = "1000000"
        setInput(input)

        // when
        val actual = ioHandler.getMoveCount()

        // then
        val expected = 1_000_000
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

    private fun setInput(input: String) {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
    }

    private fun setOutput(output: ByteArrayOutputStream) {
        System.setOut(PrintStream(output))
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
