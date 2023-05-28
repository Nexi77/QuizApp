package com.example.quizapp

data class Category (
    val id: Int,
    val image: Int,
    val text: String,
) {
    override fun toString(): String {
        return "Category(id=$id, image=$image, text='$text')"
    }
}