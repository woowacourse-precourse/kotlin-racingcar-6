package racingcar.model

class CarProgressInit {
    fun progress(carNums:Int):MutableList<Int>{
        val carProgress:MutableList<Int> = mutableListOf()
        for (i in 0..carNums){
            carProgress.add(0)
        }
        return carProgress
    }
}