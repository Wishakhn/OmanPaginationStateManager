package com.example.oman_paginationstatemanager.data


data class CarDetailDTO(
    val id: Int = 0,
    val carModel: String = "",
    val carName: String = "",
    val carPrice: String = "",
    val isBooked: Boolean = false,
    val carImage: String = "",
    val description: String = "",
    val companyId : String ="",
)


 fun getCarsList(): List<CarDetailDTO> = listOf(
    CarDetailDTO(
        id = 0,
        carModel = "Model X",
        carName = "Tesla",
        carPrice = "Rs. 8,000",
        isBooked = false,
        carImage = "https://imgd.aeplcdn.com/370x208/n/cw/ec/130591/fronx-exterior-right-front-three-quarter-109.jpeg?isig=0&q=80",
        description = "Electric luxury SUV"
    ),
    CarDetailDTO(
        id = 1,
        carModel = "911",
        carName = "Porsche",
        carPrice = "Rs. 12,000",
        isBooked = true,
        carImage = "https://imgd-ct.aeplcdn.com/370x231/n/cw/ec/150749/i20-facelift-right-front-three-quarter.jpeg?isig=0&q=80",
        description = "Sports car"
    ),
    CarDetailDTO(
        id = 2,
        carModel = "Model X",
        carName = "Tesla",
        carPrice = "Rs. 6,300",
        isBooked = false,
        carImage = "https://imgd.aeplcdn.com/370x208/n/cw/ec/141867/nexon-exterior-right-front-three-quarter-71.jpeg?isig=0&q=80",
        description = "Electric luxury SUV"
    ),
    CarDetailDTO(
        id = 3,
        carModel = "911",
        carName = "Porsche",
        carPrice = "Rs. 9,000",
        isBooked = true,
        carImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0opxaq0hJjum0XN8aeayH_-9qlSRANAD9eg&usqp=CAU",
        description = "Sports car"
    ),
    CarDetailDTO(
        id = 4,
        carModel = "Mustang",
        carName = "Ford",
        carPrice = "Rs. 5,500",
        isBooked = false,
        carImage = "https://imgd.aeplcdn.com/370x208/n/cw/ec/141867/nexon-exterior-right-front-three-quarter-71.jpeg?isig=0&q=80",
        description = "Muscle car"
    ),
    CarDetailDTO(
        id = 5,
        carModel = "XC90",
        carName = "Volvo",
        carPrice = "Rs. 2,000",
        isBooked = true,
        carImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0opxaq0hJjum0XN8aeayH_-9qlSRANAD9eg&usqp=CAU",
        description = "Luxury SUV"
    ),
    CarDetailDTO(
        id = 6,
        carModel = "Civic",
        carName = "Honda",
        carPrice = "Rs. 25,000",
        isBooked = false,
        carImage = "https://imgd.aeplcdn.com/370x208/n/cw/ec/141867/nexon-exterior-right-front-three-quarter-71.jpeg?isig=0&q=80",
        description = "Compact sedan"
    ),
)