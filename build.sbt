lazy val `SHAFIE_Ichem_Mow_Project` = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "fr/upem",
      scalaVersion := "2.12.7",
      version := "1.0.0",
      scalacOptions += "-Ypartial-unification"
    )),
    name := "SHAFIE_Ichem_Mow_Project",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test
  )