package com.example.basicnavigation.database

class User(id: Int, username:String){
    val username = username
    val id = id
}
fun User.toUserEntity() = UserEntity(
    id, username
)