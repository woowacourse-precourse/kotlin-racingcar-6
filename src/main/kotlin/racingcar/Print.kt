object Print {



    fun printCarState() {

        for(car in Game.carList.getCars()){

            val carName = car.carName
            val path = car.path

            println("$carName : $path")

        }

    }



}