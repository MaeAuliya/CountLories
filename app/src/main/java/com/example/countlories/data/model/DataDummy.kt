package com.example.countlories.data.model

object DataDummy {

    fun getDummyUserData() : List<UserModel> {
        val userList = ArrayList<UserModel>()

        for (i in 0 .. 10){
            val user = UserModel(
                "Maisan $i",
                "maisanaulia0$i@gmail.com",
                "tes123",
                "https://story-api.dicoding.dev/images/stories/photos-1641623658595_dummy-pic.png"
            )
            userList.add(user)
        }
        return userList
    }

    fun generateMenuData() : List<MenuModel> {
        val menuList = ArrayList<MenuModel>()

        for (i in 0..10){
            val menu = MenuModel(
                "Menu $i",
                "https://story-api.dicoding.dev/images/stories/photos-1641623658595_dummy-pic.png",
                "12$i Kkal",
                "Satay, or sate in Indonesian spelling, is a Southeast Asian dish of seasoned, skewered and grilled meat, served with a sauce. The earliest preparations of satay is believed to have originated in Java island, but has spread to almost anywhere in Indonesia, where it has become a national dish."
            )
            menuList.add(menu)
        }
        return menuList
    }
}