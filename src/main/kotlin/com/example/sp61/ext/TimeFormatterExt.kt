package com.example.sp61.ext

import java.text.SimpleDateFormat
import java.util.*

fun Long.formatter(format: String = "yyyy-MM-dd HH:mm:ss") :String
            = SimpleDateFormat(format).format(Date(this))
