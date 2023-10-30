package racingcar

import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.Constants.Companion.MAX_NUMBER
import racingcar.Constants.Companion.MIN_NUMBER

class CarGameManagerTest {

    @Test
    fun `랜덤값(0 - 9 사이) 부여 확인 테스트 코드`() {
        val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
        assertTrue(randomNumber in MIN_NUMBER..MAX_NUMBER)
    }
    @Test
    fun `진행 결과 출력 확인 테스트 코드`() {
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
    fun `우승자 판별 후 출력 확인 테스트 코드`() {

        val carNameListTest: List<String> = listOf("yang", "won", "sik")
        val carListCountTest = carNameListTest.size
        val oneWinnerResultTest= mutableListOf("--", "-------", "---")
        val twoWinnerResultTest= mutableListOf("-----", "----", "-----")
        val oneWinnerText = "최종 우승자 : won"
        val twoWinnerText = "최종 우승자 : yang, sik"
        val oneWinnersList: MutableList<String> = mutableListOf()
        val twoWinnersList: MutableList<String> = mutableListOf()
        val oneWinnerListLength = oneWinnerResultTest.max().length
        val twoWinnerListLength = twoWinnerResultTest.max().length
        for (countList in MIN_NUMBER until carListCountTest) {
            if (oneWinnerListLength == oneWinnerResultTest[countList].length) {
                oneWinnersList.add(carNameListTest[countList])
            }
        }
        val oneWinnerOutput = "${Constants.FINAL_WINNER_MESSAGE}${oneWinnersList.joinToString(", ")}"
        assertEquals(oneWinnerOutput,oneWinnerText)

        for (countList in MIN_NUMBER until carListCountTest) {
            if (twoWinnerListLength == twoWinnerResultTest[countList].length) {
                twoWinnersList.add(carNameListTest[countList])
            }
        }
        val twoWinnerOutput = "${Constants.FINAL_WINNER_MESSAGE}${twoWinnersList.joinToString(", ")}"
        assertEquals(twoWinnerOutput,twoWinnerText)

    }

}