package com.example.demo

data class ObjectA(
    override val id: String,
    override val description: String,
    override val data: String):  Header, Extension

