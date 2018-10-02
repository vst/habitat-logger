import ReleaseTransformations._

// Define versions for libraries:
val VersionCats              = "1.4.0"
val VersionCatsEffect        = "1.0.0"
val VersionCatsTaglessMacros = "0.1.0"
val VersionHabitatConsole    = "0.1.0"
val VersionScalameta         = "3.0.0-M11"

// Configure the root project:
lazy val root = (project in file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    // Top-level Settings:
    name := "habitat-logger",
    organization := "com.vsthost.rnd",
    scalaVersion := "2.12.7",
    version := "0.1.0-SNAPSHOT",

    // Scalac Options:
    scalacOptions += "-deprecation",
    scalacOptions += "-Xplugin-require:macroparadise",
    scalacOptions in (Compile, console) := Seq(),

    // BuildInfo Settings:
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "com.vsthost.rnd.habitat.logger",

    // Compiler plugins:
    addCompilerPlugin(("org.scalameta" % "paradise" % VersionScalameta).cross(CrossVersion.full)),

    // Release/Publish settings:
    useGpg := true,
    releasePublishArtifactsAction := PgpKeys.publishSigned.value,
    publishTo := Some(if (isSnapshot.value) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies, // : ReleaseStep
      inquireVersions,           // : ReleaseStep
      runClean,                  // : ReleaseStep
      runTest,                   // : ReleaseStep
      setReleaseVersion,         // : ReleaseStep
      //commitReleaseVersion,    // : ReleaseStep, performs the initial git checks
      //tagRelease,              // : ReleaseStep
      publishArtifacts,          // : ReleaseStep, checks whether `publishTo` is properly set up
      //setNextVersion,          // : ReleaseStep
      //commitNextVersion,       // : ReleaseStep
      //pushChanges              // : ReleaseStep, also checks that an upstream branch is properly configured
    ),

    // Libraries:
    libraryDependencies ++= Seq(
      "org.typelevel"   %% "cats-core"           % VersionCats,
      "org.typelevel"   %% "cats-effect"         % VersionCatsEffect,
      "org.typelevel"   %% "cats-tagless-macros" % VersionCatsTaglessMacros,
      "com.vsthost.rnd" %% "habitat-console"     % VersionHabitatConsole,
    )
  )