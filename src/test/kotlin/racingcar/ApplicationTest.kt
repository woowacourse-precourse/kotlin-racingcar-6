package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import racingcar.view.InputView

/* TestInstance : 변수가 하나의 인스턴스를 공유하여, 각각의 테스트 메소드에서 사용됨.
JUnit은 개별 테스트의 독립성 보장과 테스트 사이의 Side Effect를 최소화 하기 위해,
테스트 메소드의 실행 전 사용되는 변수에 각각 새로운 인스턴스를 생성한다.
하지만, 정적이고 불변인 데이터에 대해서 새로운 인스턴스를 생성하는 것은 메모리
낭비로 이어질 수 있으니 적절하게 TestInstance를 사용하여 메모리를 절약하고, 성능을 확보하자.

좋은 단위 테스트를 위한 FIRST 규칙
- Fast : 단위 테스트는 빨라야 한다.
- Independent : 테스트는 독립적으로 동작해야 한다. (그래야 실패 원인을 찾기 쉽다)
- Repeatable : 어떤 상황에서든 예상한 대로 테스트 결과가 나와야 한다.**
- Self-Validating : 출력 혹은 로그가 아닌 테스트 자체적으로 결과가 나와야 한다.
- Timely : 적시에 테스트를 철저하게 작성해야 한다.

given - when - then 패턴을 사용해보자.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTest : NsTest() {
    val inputView = InputView()

    @ParameterizedTest
    @ValueSource(strings = ["pobi, asd, 123"])
    @DisplayName("InputView: splitCarNamesByComma() - Multi")
    fun `여러 이름을 입력 받은 경우) ','로 분류하여 리스트 반환`(inputNames: String) {
        assertThat(
            inputView.splitCarNamesByComma(inputNames)
        ).containsExactly("pobi", " asd", " 123")
    }

    @ParameterizedTest
    @ValueSource(strings = ["asd" , " 123", "pobi ", "  jun", "taeng"])
    @DisplayName("InputView: splitCarNamesByComma() - Single")
    fun `하나의 이름을 입력 받은 경우) 하나를 리스트에 넣고 반환`(inputNames: String) {
        assertThat(
            inputView.splitCarNamesByComma(inputNames)
        ).isEqualTo(listOf(inputNames))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "    ", "Pobi12", "123456"])
    @DisplayName("Car(init): checkNameLength()")
    fun `(좌우 공백 제거된) 차 이름이 1~5 이내 인지 확인`(inputName: String) {
        // JUnit5 lib : assertThrows
        val exception = assertThrows<IllegalArgumentException> {
            Car(inputName)
        }
        assertEquals(Car.CAR_NAME_LENGTH_ERROR, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Car!", "Car@2", "My!!!", "!! !!", "! !", "()_+"])
    @DisplayName("Car(init): checkNameLetter()")
    fun `(좌우 공백 제거된) 차 이름이 한글, 영문, 숫자로 구성되어 있는지 확인`(inputName: String) {
        // AssertJ lib : assertThatThrownBy
        assertThatThrownBy { Car(inputName) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Car.CAR_NAME_FORMAT_ERROR)
    }

//    @ParameterizedTest
//    @MethodSource("")
//    @DisplayName("(Cars_init) ")
//    fun `(좌우 공백 제거된) 차 이름이 한글, 영문, 숫자로 구성되어 있는지 확인`(carInstance: Car) {
//        assertThatThrownBy { Cars(carInstance) }
//            .isInstanceOf(IllegalArgumentException::class.java)
//            .hasMessageContaining(Car.CAR_NAME_FORMAT_ERROR)
//    }

//    @Test
//    fun `반복 횟수 입력 오류테스트`() {
//        val TestExceptionList = listOf("a", "^", "0", "-1")
//
//        TestExceptionList.forEach {
//            assertThrows<IllegalArgumentException> {
//                Repetition(it)
//            }
//        }
//    }
//
//    @Test
//    fun `반복 횟수 입력 테스트`() {
//        val TestList = listOf("1", "512", "123")
//
//        TestList.forEach {
//            assertDoesNotThrow {
//                Repetition(it)
//            }
//        }
//    }

//    @Test
//    fun `전진 정지`() {
//        assertRandomNumberInRangeTest(
//            {
//                run("pobi,woni", "1")
//                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
//            },
//            MOVING_FORWARD, STOP
//        )
//    }
//
//    @Test
//    fun `이름에 대한 예외 처리`() {
//        assertSimpleTest {
//            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
//        }
//    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
