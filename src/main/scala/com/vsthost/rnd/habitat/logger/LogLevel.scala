package com.vsthost.rnd.habitat.logger

import com.vsthost.rnd.habitat.logger

/**
  * Provides an enumeration of log levels.
  */
object LogLevel extends Enumeration {
  type LogLevel = Value
  val TRACE: logger.LogLevel.Value = Value(1)
  val DEBUG: logger.LogLevel.Value = Value(2)
  val INFO: logger.LogLevel.Value = Value(3)
  val WARN: logger.LogLevel.Value = Value(4)
  val ERROR: logger.LogLevel.Value = Value(5)
  val FATAL: logger.LogLevel.Value = Value(6)
  val NEVER: logger.LogLevel.Value = Value(100)
}
