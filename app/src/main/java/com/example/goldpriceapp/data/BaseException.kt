package com.example.shahabrah.core.base



class BaseException(
    val exception: String,
    val file: String,
    val line: Int,
    override val message: String,
    val trace: List<Trace>
    ) : Throwable() {

        enum class Type {
            AUTH, INTERNET, SERVER, BAD_REQUEST, NOT_FOUND
        }

    }

data class Trace(
    val `class`: String,
    val `file`: String,
    val function: String,
    val line: Int,
    val type: String
)
