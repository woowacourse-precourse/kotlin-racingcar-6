package racingcar

import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Assertions.assertEquals
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
    @Test
    fun `진행결과 출력`() {
        val carNameListTest: List<String> = listOf("yang", "won", "sik")
        val carListCountTest = carNameListTest.size
        val carResultListTest = MutableList(carListCountTest) { "" }
        val randomValueList: List<Int> = listOf(4, 2, 8)
        val outputTestList: List<String> = listOf("yang : -","won : ","sik : -")
        for (countList in 0 until carListCountTest) { // MIN_NUMBER 제거
            if (randomValueList[countList] >= Constants.FORWARD_CONDITION) {
                carResultListTest[countList] += "-"
            }
            val output = "${carNameListTest[countList]} : ${carResultListTest[countList]}"
            assertEquals(output, outputTestList[countList])
        }
    }
    @Test
    fun `우승자 출력 테스트`(){

        val carNameListTest: List<String> = listOf("yang", "won", "sik")
        val carListCountTest = carNameListTest.size
        val twoWinnerResultTest: MutableList<String> = mutableListOf("-----","----","-----")
        val oneWinnerResultTest: MutableList<String> = mutableListOf("--","-------","---")
        val oneWinnerText = "최종 우승자 : won"
        val twoWinnerText = "최종 우승자 : yang, sik"
        assertEquals(CarGameManager().determineWinnersAndPrint(oneWinnerResultTest,carListCountTest,carNameListTest),oneWinnerText)
        assertEquals(CarGameManager().determineWinnersAndPrint(twoWinnerResultTest,carListCountTest,carNameListTest),twoWinnerText)
    }
}