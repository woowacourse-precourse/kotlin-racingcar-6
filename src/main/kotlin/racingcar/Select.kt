object Select {

    fun selectWinner(cars : MutableList<Car>) : MutableList<String>{

        val winner  = mutableListOf<String>()

        val maxNum = findMax(cars)

        for(car in cars){

            if(maxNum == car.forwardCount)
                winner.add(car.carName)


        }

        return winner

    }

    private fun findMax(cars : MutableList<Car>): Int {

        var max = 0


        for(car in cars){

            if(max < car.forwardCount)
                max = car.forwardCount

        }


        return max

    }


}