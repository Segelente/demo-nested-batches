package com.example.demo

data class ObjectB(override val id: String, override val description: String, val objectC: List<ObjectC>): Header