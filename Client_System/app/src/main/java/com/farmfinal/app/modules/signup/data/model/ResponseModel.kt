package com.farmfinal.app.modules.signup.data.model

import kotlin.String

data class ResponseModel (
    val status: String="", // Add fields according to your actual response
    val message: String="",
    val issuccess: Boolean=false
)