class Game {

    companion object {
        val carList : CarList = CarList(mutableListOf<Car>() , 0)
    }


    fun start(){

        //1. 초기 설정
        InitSetting.initSet()

        //2. 카 시뮬레이션 실행
        carList.carSimul()


        //3. 우승자 선정
        val winners = Select.selectWinner(carList.getCars())




    }


}