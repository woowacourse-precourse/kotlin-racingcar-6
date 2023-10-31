package racingcar


class RunGame {

    fun startRace(){
        var racingCars : MutableList<Players> = mutableListOf (PrepareGame().racingCarName())
        var racingNum: Int = PrepareGame().racingNumber()

        for( i in 1..racingNum){ // 전체 경주 실행 횟수 반복
            eachRace(racingCars.lenghth)

            // 그 안에서 플레이어 횟수만큼 반복
                //그리고 랜덤 넘버 생성
                // 넘버가 4보다 큰지 확인
                // 넘버가 4보다 크면 전진
        }


        var winnerList:ArrayList<String> = PostGame().getWinner()
        PostGame().printWinner(winnerList)

    }

}