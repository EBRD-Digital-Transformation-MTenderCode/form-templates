package com.procurement.formsservice.pebble.extension

import com.mitchellbosecke.pebble.extension.AbstractExtension
import com.mitchellbosecke.pebble.extension.Function

object FormExtension : AbstractExtension() {
    override fun getFunctions(): Map<String, Function> = mutableMapOf<String, Function>().apply {
        this["findSubString"] = FindSubString
    }
}

object FindSubString : Function {
    private const val TEXT_PARAMETER = "text"
    private const val REGEX_PARAMETER = "regex"
    override fun getArgumentNames(): List<String> = mutableListOf<String>().apply {
        add(TEXT_PARAMETER)
        add(REGEX_PARAMETER)
    }

    override fun execute(parameters: MutableMap<String, Any>): Any {
        val text = parameters[TEXT_PARAMETER] as String
        val regex = (parameters[REGEX_PARAMETER] as String).toRegex()
        return regex.matches(text)
    }
}