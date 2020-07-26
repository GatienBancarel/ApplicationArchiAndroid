package com.tech.myapplication.repository

import java.lang.Exception

class CannotDecodeJsonException (val reason: String) : Exception(reason)