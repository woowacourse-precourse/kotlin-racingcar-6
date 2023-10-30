package racingcar

import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.Constants.Companion.MAX_NUMBER
import racingcar.Constants.Companion.MIN_NUMBER

class CarGameManagerTest {

    @Test
    fun `랜덤값이 0 - 9 사이가 맞는지 확인`() {
        val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
        assertTrue(randomNumber in MIN_NUMBER..MAX_NUMBER)
    }

}