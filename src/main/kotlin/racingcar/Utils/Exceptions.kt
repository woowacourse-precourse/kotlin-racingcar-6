package racingcar.Utils

import racingcar.Utils.Constans.EXCEPTION_EXCEED_FIVE_LETTERS
import racingcar.Utils.Constans.EXCEPTION_NAME_CONTAINS_NON_LETTER
import racingcar.Utils.Constans.EXCEPTION_NUMBER_UNVALID

class Exceptions {
    companion object {
        fun checkNameListInput(list : List<String>){
            checkAllNameInFiveLetters(list)
            checkPossibleNames(list)
        }
        private fun checkAllNameInFiveLetters(list : List<String>) {
            require(list.all { it.length <= 5 }) { EXCEPTION_EXCEED_FIVE_LETTERS }
        }

        private fun checkPossibleNames(list : List<String>) {
            list.forEach {
                checkPossibleName(it)
            }
        }

        private fun checkPossibleName(name : String) {
            require(name.all { it.isLetter() }) { EXCEPTION_NAME_CONTAINS_NON_LETTER }
        }

        fun checkNumber(number : String) {
            require(number.all { it.isDigit() }) { EXCEPTION_NUMBER_UNVALID }
            //2000명이 동시에 진행하는 자동차 레이스 경주는 없음.
            //https://www.reddit.com/r/iRacing/comments/keuu7j/maximum_participants_per_race/?rdt=39933
            //바이크 레이스의 경우 검색결과 최대 1500명이 참가
            //https://namu.wiki/w/%EC%97%90%EB%A5%B4%EC%B8%A0%EB%B2%84%EA%B7%B8%20%EB%A1%9C%EB%8D%B0%EC%98%A4
            require(number.toLong() < Int.MAX_VALUE.toLong()) { "불가능한 이동 횟수 입니다" }
        }
    }
}