package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `조건에 맞는 이름 1개를 입력 받는다`() {
        // given
        val name = "pobi"
        val result = listOf("pobi")

        // when

        // then
    }

    @Test
    fun `5자를 초과하는 이름을 입력받는다`() {
        // given
        val name = "123456"
        // throw IllegalArgumentException

        // when

        // then
    }

    @Test
    fun `특수 문자를 사용하는 이름을 입력 받는다`() {
        // given
        val name = "굿이모지👍"
        val result = listOf("굿이모지👍")

        // when

        // then
    }
    
    @Test
    fun `세 개의 이름을 입력 받는다`() {
        // given
        val names = "pobi,영수,철수"
        val result = listOf("pobi", "영수", "철수")
        
        // when
        
        // then
    }
    
    @Test
    fun `"를 사용하는 이름을 입력받는다`() {
        // given
        val name = "가\"나다라"
        val result = listOf("""가"나다""")
        
        // when
        
        // then
    }

    @Test
    fun `line break을 이름으로 입력받는다`() {
        // given
        val name = """이\n름, 정상이름"""
        val result = listOf("""이\n름""", "정상이름")

        // when

        // then
    }
    
    @Test
    fun `빈 이름을 1개 입력 받는다`() {
        // given
        val name = ""
        val result: List<String>
        
        // when
        
        // then
    }
    
    @Test
    fun `공백 이름을 1개 입력 받는다`() {
        // given
        val name = " "
        val result = listOf(" ")
        
        // when
        
        // then
    }

    @Test
    fun `중간에 공백이 있는 이름을 입력 받는다`() {
        // given
        val name = "김 치"
        val result = listOf("김 치")

        // when

        // then
    }

    @Test
    fun `끝에 공백이 있는 이름을 입력 받는다`() {
        // given
        val name = "김치 "
        val result = listOf("김치 ")

        // when

        // then
    }
    
    @Test
    fun `공백 이름을 3개 입력 받는다`() {
        // given
        val name = " ,   ,  "
        val result = listOf(" ", "   ","  ")
        
        // when
        
        // then
    }
    
    @Test
    fun `빈 이름과 공백 이름을 입력 받는다`() {
        // given
        val names = ",  , "
        val result: List<String>
        
        // when
        
        // then
    }
    
    @Test
    fun `중복된 이름을 입력 받는다`() {
        // given
        val names = "아우디, 아우지, 아우디"
        val result = listOf("아우디", "아우지", "아우디")
        
        // when
        
        // then
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

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
