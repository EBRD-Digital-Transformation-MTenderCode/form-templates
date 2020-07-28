package com.procurement.formsservice.pebble.function

import com.mitchellbosecke.pebble.extension.Function

object AttributeIf : Function {
    private const val NAME_PARAMETER = "name"
    private const val VALUE_PARAMETER = "value"

    override fun getArgumentNames(): List<String> = mutableListOf<String>().apply {
        add(NAME_PARAMETER)
        add(VALUE_PARAMETER)
    }

    override fun execute(parameters: MutableMap<String, Any>): Any {
        val value = parameters[VALUE_PARAMETER] ?: return ""
        val name = parameters[NAME_PARAMETER] as String

        val quote = when (value) {
            is String -> "\""
            else -> ""
        }

        return """"$name": $quote$value$quote"""
    }
}