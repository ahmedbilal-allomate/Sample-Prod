package com.example.myapplication.data

import com.example.myapplication.model.User

 class RecyclerData {

    fun addData(): Any {
        val users = ArrayList<User>()
        users.add(User("Bilal", "Expo", "12345", "200"))
        users.add(User("Usama", "Johar", "3456789", "500"))
        users.add(User("Osama", "Town", "213424", "700"))
        users.add(User("Wakas", "Town", "213424", "700"))
        users.add(User("Adeel", "Town", "213424", "700"))

        return users
    }

}