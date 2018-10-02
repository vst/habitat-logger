package com.vsthost.rnd.habitat.logger

import cats.effect.IO
import com.vsthost.rnd.habitat.console.Console
import com.vsthost.rnd.habitat.logger.LogLevel.LogLevel


/**
  * Provides a definitions for convenience.
  */
package object simple {
  /**
    * Default the default instance for `Logger[IO]`
    */
  def io(logLevel: LogLevel)(implicit c: Console[IO]): SimpleConsoleLogger[IO] =
    new SimpleConsoleLogger[IO](logLevel)
}
