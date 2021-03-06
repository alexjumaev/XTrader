package com.sedsoftware.core.tools.api

interface Signer {
    fun signWithSha1(text: String, key: String): String
    fun signWithSha256(text: String, key: String): String
}
