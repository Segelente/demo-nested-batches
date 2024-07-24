package com.example.demo
import org.springframework.graphql.data.method.annotation.BatchMapping

import graphql.GraphQLContext
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class DemoController {
    @QueryMapping
    fun query(): ReturnObject {
        return ReturnObject("ABC123", null)
    }

    @SchemaMapping(typeName = "ReturnObject", field = "header")
    fun returnHeader(): List<Header> {
        return listOf(ObjectA("ObjA", "This is Object A", "12 Million"), ObjectB("ObjB", "This is Object B", listOf(ObjectC("ObjC", "2 Million"))))
    }

    @BatchMapping(typeName = "Extension", field = "data")
    fun getExtensionData(extensionObjects: List<Extension>, context: GraphQLContext): Map<Extension, String> {
        println("This function was called")
        return extensionObjects.associateWith { it.id }
    }
}