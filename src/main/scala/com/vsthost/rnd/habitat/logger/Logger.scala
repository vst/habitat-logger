package com.vsthost.rnd.habitat.logger

import cats.tagless.finalAlg
import com.vsthost.rnd.habitat.logger.LogLevel.LogLevel

import scala.language.higherKinds

/**
  * Provides the logger algebra.
  *
  * @tparam F Context type parameter.
  */
@finalAlg
trait Logger[F[_]] {
  /**
    * Writes a log message.
    *
    * @param level Log level of the message.
    * @param message Message to be logged.
    * @return [[Unit]] in context.
    */
  def write(level: LogLevel, message: => String): F[Unit]

  /**
    * Logs a [[LogLevel.TRACE]] level message.
    *
    * @param message The message to be logged.
    * @return [[Unit]] in context.
    */
  def trace(message: => String): F[Unit] = write(LogLevel.TRACE, message)

  /**
    * Logs a [[LogLevel.DEBUG]] level message.
    *
    * @param message The message to be logged.
    * @return [[Unit]] in context.
    */
  def debug(message: => String): F[Unit] = write(LogLevel.DEBUG, message)

  /**
    * Logs a [[LogLevel.INFO]] level message.
    *
    * @param message The message to be logged.
    * @return [[Unit]] in context.
    */
  def info(message: => String): F[Unit] = write(LogLevel.INFO, message)

  /**
    * Logs a [[LogLevel.WARN]] level message.
    *
    * @param message The message to be logged.
    * @return [[Unit]] in context.
    */
  def warn(message: => String): F[Unit] = write(LogLevel.WARN, message)

  /**
    * Logs a [[LogLevel.ERROR]] level message.
    *
    * @param message The message to be logged.
    * @return [[Unit]] in context.
    */
  def error(message: => String): F[Unit] = write(LogLevel.ERROR, message)

  /**
    * Logs a [[LogLevel.FATAL]] level message.
    *
    * @param message The message to be logged.
    * @return [[Unit]] in context.
    */
  def fatal(message: => String): F[Unit] = write(LogLevel.FATAL, message)
}
