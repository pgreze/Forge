package com.github.kittinunf.forge.deserializer

import com.github.kittinunf.forge.core.AttributeTypeInvalidError
import com.github.kittinunf.forge.core.DeserializedResult
import com.github.kittinunf.forge.core.JSON
import com.github.kittinunf.forge.core.JSON.Null
import com.github.kittinunf.result.Result.Failure
import com.github.kittinunf.result.Result.Success

inline fun <reified T : Any?> JSON.deserializeAs(key: String? = null): DeserializedResult<T> = when (this) {
    is Null -> Success(null as T)
    else -> {
        (value as? T)?.let(::Success) ?: Failure(AttributeTypeInvalidError(key ?: "(null)", T::class.java, value))
    }
}
