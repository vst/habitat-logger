sonatypeProfileName := "com.vsthost"

publishMavenStyle := true

licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

import xerial.sbt.Sonatype._

sonatypeProjectHosting := Some(GitHubHosting("vst", "habitat-logger", "vst@vsthost.com"))

homepage := Some(url("https://github.com/vst/habitat-logger"))

scmInfo := Some(
  ScmInfo(url("https://github.com/vst/habitat-logger"), "scm:git@github.com:vst/habitat-logger.git")
)

developers := List(
  Developer(id="vst", name="Vehbi Sinan Tunalioglu", email="vst@vsthost.com", url=url("https://github.com/vst"))
)
