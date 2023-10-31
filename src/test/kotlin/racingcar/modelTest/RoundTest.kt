package racingcar.modelTest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.utils.Round

class RoundTest {
    @Test
    @DisplayName("Round : generateRandomNumber() - Range Test")
    fun `랜덤 숫자가 범위 안에 있는지 검증`() {
        repeat(1000) {
            assertTrue(Round.generateRandomNumber() in Round.RANDOM_RANGE_START..Round.RANDOM_RANGE_END)
        }
    }

    // Q. Randoms의 pickNumberInRange 메소드 검증인데, 하는 게 맞을까?
    // GPT A. 신뢰도가 충분히 검증된 라이브러리라면 불필요해 보인다. 또한, 이 메서드의
    // 정확성 테스트는 라이브러리 제작자나 커뮤니티의 책임일 수 있다. -> 내가 할 부분이 아니다.
//    @Test
//    @DisplayName("Round : generateRandomNumber() - distribution Test")
//    fun `랜덤 숫자의 0~9 분포 검증`() { // n = 10000일 때, 99.92% 확률
//        val numberCount = Array(10) { 0 }
//
//        repeat(10000) {
//            numberCount[Round.generateRandomNumber()]++
//        }
//
//        println(numberCount.contentToString())
//        numberCount.forEachIndexed { index, count ->
//            assertTrue(count in 900..1100, "distribution Test Fail")
//        }
//    }

    // Q. 과연 이렇게 간단한 메소드 까지 테스트를 작성해야 할까?
    // GPT A. 단순하게 코드의 길이 보다는, 함수의 역할과 중요성을 기준으로 작성하는 게 좋다.
    // GPT C. 경주 게임의 전진 조건을 결정하는 핵심 로직이므로 하는 것을 추천한다.
    @Test
    @DisplayName("Round : isForward()")
    fun `전진 조건 검증  3이하 - 정지(false), 4이상 - 전진(true)`() {
        for (i in Round.RANDOM_RANGE_START until Round.FORWARD_THRESHOLD) {
            assertFalse(Round.isForward(i))
        }
        for (i in Round.FORWARD_THRESHOLD..Round.RANDOM_RANGE_END) {
            assertTrue(Round.isForward(i))
        }
    }
}