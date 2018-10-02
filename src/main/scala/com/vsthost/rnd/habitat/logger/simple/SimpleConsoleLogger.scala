package com.vsthost.rnd.habitat.logger.simple

import java.time.LocalDateTime

import cats.effect._
import com.vsthost.rnd.habitat.console.Console
import com.vsthost.rnd.habitat.console.implicits.writer.fancy
import com.vsthost.rnd.habitat.logger.LogLevel.LogLevel
import com.vsthost.rnd.habitat.logger.{LogLevel, Logger}

import scala.language.higherKinds

/**
  * Provides a console logger program for a [[Sync]] instance.
  *
  * @param F Evidence for the context type parameter.
  * @tparam F Context type parameter.
  */
class SimpleConsoleLogger[F[_]: Sync: Console](logLevel: LogLevel) extends Logger[F] {
  /**
    * Provides ANSI effects for the console message as per log level.
    */
  private val styles = Map(
    LogLevel.TRACE -> fancy.strBlue,
    LogLevel.DEBUG -> fancy.strCyan,
    LogLevel.INFO -> fancy.strGreen,
    LogLevel.WARN -> fancy.strYellow,
    LogLevel.ERROR -> fancy.strRed,
    LogLevel.FATAL -> fancy.strMagenta,
  )

  /**
    * Writes a log message to the console if log level is suitable.
    *
    * @param level   Log level of the message.
    * @param message Message to be logged.
    * @return [[Unit]] in context.
    */
  override def write(level: LogLevel, message: => String): F[Unit] =
    if (level < logLevel)
      Sync[F].unit
    else
      Console[F].putErrLn(s"[${LocalDateTime.now}]} $message")(styles(level))
}
