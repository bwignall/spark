/** Copyright (C) 2014-2018. All Rights Reserved.
  *
  * E: something@gmail.com
  */

// https://typelevel.org/sbt-typelevel/faq.html#what-is-a-base-version-anyway
ThisBuild / tlBaseVersion := "0.0" // your current series x.y

ThisBuild / organization := "org.apache.spark"
ThisBuild / version := "0.1.0-SNAPSHOT"

// publish website from this branch
ThisBuild / githubWorkflowPublishTargetBranches := Seq()

// dependency tracking
ThisBuild / tlCiDependencyGraphJob := false

// generate documentation
ThisBuild / tlCiDocCheck := false

// Not currently bothering to generate/check headers
ThisBuild / tlCiHeaderCheck := false

val PrimaryJava = JavaSpec.temurin("21")
val LTSJava = JavaSpec.temurin("17")
val GraalVM = JavaSpec.graalvm("17")

ThisBuild / githubWorkflowJavaVersions := Seq(PrimaryJava, LTSJava, GraalVM)

val Scala213 = "2.13.13"
val Scala3 = "3.3.3"
ThisBuild / crossScalaVersions := Seq(Scala213, Scala3)
ThisBuild / scalaVersion := Scala213 // the default Scala

lazy val root = tlCrossRootProject.aggregate(common_tags, common_utils, core)

cancelable := true

developers := List( // TODO replace this with your information
  Developer(
    "mslinn",
    "Mike Slinn",
    "mslinn@micronauticsresearch.com",
    url("https://github.com/mslinn")
  )
)

//ThisBuild / javaHome := {
//  val javaHomePath = System.getProperty("java.home")
//  Option(file(javaHomePath))
//}

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "--enable-preview",
//  "-source",
//  "1.16",
//  "-target",
//  "1.16",
  "-g:vars",
  "--release",
  "16"
)

//scalacOptions ++= Seq("-java-output-version", "16")
scalacOptions ++= Seq(
  "-source",
  "16",
  "-target",
  "16"
)

//fork := true
fork := false

val codehausjacksonV = "1.9.13"
val fasterxmljacksonV = "2.17.1"
val fasterxmljacksondatabindV = "2.17.1"
val wsxmlschemaV = "2.3.1"
val orgglassfishjaxbtxw2V = "3.0.2"
val snappyV = "1.1.10.5"
val netlibludovicdevV = "3.0.3"
val commonscodecV = "1.17.0"
val commonscompressV = "1.26.2"
val commonsioV = "2.16.1"
val commonslang2V = "2.6"
val commonslang3V = "3.14.0"
val commonspool2V = "2.12.0"
val datanucleuscoreV = "4.1.17"

val mariadbjavaclientV = "2.7.12"
val mysqlconnectorV = "8.4.0"
val postgresqlV = "42.7.3"
val db2jccV = "11.5.9.0"
val mssqljdbcV = "12.6.2.jre11"
val ojdbc11V = "23.4.0.24.05"

val antlr4V = "4.13.1"
val guavaV = "14.0.1"
val janinoV = "3.1.9"
val jerseyV = "3.0.12"
val jodaV = "2.12.7"
val joddV = "3.5.2"
val jsr305V = "3.0.0"
val jaxbV = "2.2.11"
val libthriftV = "0.16.0"
val jpamV = "1.1"
val seleniumV = "4.17.0"
val htmlunit3driverV = "4.17.0"
val mavenantrunV = "3.1.0"
val commonscryptoV = "1.1.0"
val commonscliV = "1.8.0"
val bouncycastleV = "1.78"
val tinkV = "1.13.0"
val datasketchesV = "6.0.0"
val nettyV = "4.1.110.Final"
val nettytcnativeV = "2.0.65.Final"
val icu4jV = "72.1"
val junitJupiterV = "5.9.3"
val junitPlatformV = "1.9.3"
val sbtJupiterInterfaceV = "0.11.1"

val arrowV = "16.1.0"
val ammoniteV = "3.0.0-M2"
val kubernetesClientV = "6.13.0"

val asmV = "9.7"
val slf4jV = "2.0.13"
val log4jV = "2.22.1"
val hadoopV = "3.4.0"
val protobufV = "3.25.1"
val protocjarmavenpluginV = "3.11.4"
val yarnV = hadoopV
val curatorV = "5.7.0"
val hiveV = "2.3.10"
val hivestorageV = "2.8.1"
val kafkaV = "3.7.0"
val derbyV = "10.16.1.1"
val parquetV = "1.14.1"
val orcV = "2.0.1"
val jettyV = "11.0.21"
val jakartaservletV = "5.0.0"
val javaxservletV = "4.0.1"
val chillV = "0.10.0"
val ivyV = "2.5.2"
val oroV = "2.0.8"
val codahalemetricsV = "4.2.26"
val avroV = "1.11.3"
val awskinesisclientV = "1.12.0"
val awsjavasdkV = "1.11.655"
val awsjavasdkv2V = "2.24.6"
val awskinesisproducerV = "0.12.8"
val gcsconnectorV = "hadoop3-2.2.21"
val commonshttpclientV = "4.5.14"
val commonshttpcoreV = "4.4.16"
val commonsmath3V = "3.6.1"
val commonscollectionsV = "3.2.2"
val commonscollections4V = "4.4"

val zookeeperV = "3.9.2"

lazy val commonJvmSettings = Seq(
  libraryDependencies ++= Seq(
    "commons-cli" % "commons-cli" % commonscliV,
    "commons-codec" % "commons-codec" % commonscodecV,
    "commons-collections" % "commons-collections" % commonscollectionsV,
    "commons-io" % "commons-io" % commonsioV,
    "commons-lang" % "commons-lang" % commonslang2V,
    "com.clearspring.analytics" % "stream" % "2.9.8",
    "com.fasterxml.jackson.core" % "jackson-annotations" % fasterxmljacksonV,
    "com.fasterxml.jackson.core" % "jackson-core" % fasterxmljacksonV,
    "com.fasterxml.jackson.core" % "jackson-databind" % fasterxmljacksondatabindV,
    "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % fasterxmljacksonV,
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % fasterxmljacksonV,
    "com.github.docker-java" % "docker-java" % "3.3.6" % Test,
    "com.github.docker-java" % "docker-java-transport-zerodep" % "3.3.6" % Test,
    "com.github.jnr" % "jnr-posix" % "3.1.15" % Test,
    "com.github.luben" % "zstd-jni" % "1.5.6-3",
    "com.google.code.findbugs" % "jsr305" % jsr305V,
    "com.google.crypto.tink" % "tink" % tinkV,
    "com.google.guava" % "guava" % guavaV,
    "com.google.protobuf" % "protobuf-java" % protobufV % Provided,
    "com.google.protobuf" % "protobuf-java-util" % protobufV % Provided,
    "com.ibm.db2" % "jcc" % db2jccV % Test,
    "com.ibm.icu" % "icu4j" % icu4jV,
    "com.microsoft.sqlserver" % "mssql-jdbc" % mssqljdbcV % Test,
    "com.ning" % "compress-lzf" % "1.1.2",
    "com.mysql" % "mysql-connector-j" % mysqlconnectorV % Test,
    "com.oracle.database.jdbc" % "ojdbc11" % ojdbc11V % Test,
    "com.puppycrawl.tools" % "checkstyle" % "10.17.0",
    "com.twitter" % "chill-java" % chillV,
    "com.twitter" %% "chill" % chillV,
    "com.univocity" % "univocity-parsers" % "2.9.1",
    "dev.ludovic.netlib" % "arpack" % netlibludovicdevV,
    "dev.ludovic.netlib" % "blas" % netlibludovicdevV,
    "dev.ludovic.netlib" % "lapack" % netlibludovicdevV,
    "io.airlift" % "aircompressor" % "0.27",
    "io.dropwizard.metrics" % "metrics-core" % codahalemetricsV,
    "io.dropwizard.metrics" % "metrics-graphite" % codahalemetricsV,
    "io.dropwizard.metrics" % "metrics-jmx" % codahalemetricsV,
    "io.dropwizard.metrics" % "metrics-json" % codahalemetricsV,
    "io.dropwizard.metrics" % "metrics-jvm" % codahalemetricsV,
    "io.netty" % "netty-all" % nettyV,
    "io.netty" % "netty-tcnative-boringssl-static" % nettytcnativeV,
    "io.netty" % "netty-transport-native-epoll" % nettyV,
    "io.netty" % "netty-transport-native-kqueue" % nettyV,
    "jakarta.servlet" % "jakarta.servlet-api" % jakartaservletV,
    "javax.activation" % "activation" % "1.1.1",
    "javax.servlet" % "javax.servlet-api" % javaxservletV,
    "javax.ws.rs" % "javax.ws.rs-api" % "2.0.1",
    "javax.xml.bind" % "jaxb-api" % jaxbV,
    "jline" % "jline" % "2.14.6",
    "joda-time" % "joda-time" % "2.12.7",
    "junit" % "junit" % "4.12" % Test,
    "net.aichler" % "jupiter-interface" % sbtJupiterInterfaceV % Test,
    "net.bytebuddy" % "byte-buddy-agent" % "1.14.11" % Test,
    "net.bytebuddy" % "byte-buddy" % "1.14.11" % Test,
    "net.sf.jpam" % "jpam" % jpamV,
    "org.antlr" % "antlr4-runtime" % antlr4V,
    "org.apache.arrow" % "arrow-memory-netty" % arrowV,
    "org.apache.arrow" % "arrow-vector" % arrowV,
//  "org.apache.avro" % "avro-mapred" % avroV,
//  "org.apache.avro" % "avro" % avroV,
    "org.apache.commons" % "commons-collections4" % commonscollections4V,
    "org.apache.commons" % "commons-compress" % commonscompressV,
    "org.apache.commons" % "commons-crypto" % commonscryptoV,
    "org.apache.commons" % "commons-lang3" % commonslang3V,
    "org.apache.commons" % "commons-math3" % commonsmath3V,
    "org.apache.commons" % "commons-text" % "1.12.0",
    "org.apache.curator" % "curator-client" % curatorV,
    "org.apache.curator" % "curator-framework" % curatorV,
    "org.apache.curator" % "curator-recipes" % curatorV,
    "org.apache.curator" % "curator-test" % curatorV % Test,
    "org.apache.datasketches" % "datasketches-java" % datasketchesV,
    "org.apache.derby" % "derbytools" % derbyV,
    "org.apache.derby" % "derby" % derbyV,
    "org.apache.hadoop" % "hadoop-client-api" % hadoopV,
    "org.apache.hadoop" % "hadoop-client-minicluster" % yarnV % Test,
    "org.apache.hadoop" % "hadoop-client-runtime" % hadoopV,
    "org.apache.hadoop" % "hadoop-client" % hadoopV,
    "org.apache.hadoop" % "hadoop-minikdc" % hadoopV % Test,
    "org.apache.hadoop" % "hadoop-yarn-api" % yarnV,
    "org.apache.hadoop" % "hadoop-yarn-client" % yarnV,
    "org.apache.hadoop" % "hadoop-yarn-common" % yarnV,
    "org.apache.hadoop" % "hadoop-yarn-server-resourcemanager" % yarnV % Test,
    "org.apache.hadoop" % "hadoop-yarn-server-tests" % yarnV % Test,
    "org.apache.hive" % "hive-beeline" % hiveV,
    "org.apache.hive" % "hive-cli" % hiveV,
    "org.apache.hive" % "hive-common" % hiveV,
    "org.apache.hive" % "hive-exec" % hiveV,
    "org.apache.hive" % "hive-jdbc" % hiveV,
    "org.apache.hive" % "hive-llap-client" % hiveV % Test,
    "org.apache.hive" % "hive-llap-common" % hiveV,
    "org.apache.hive" % "hive-metastore" % hiveV,
    "org.apache.hive" % "hive-serde" % hiveV,
    "org.apache.hive" % "hive-service-rpc" % "4.0.0",
    "org.apache.hive" % "hive-shims" % hiveV,
    "org.apache.httpcomponents" % "httpclient" % commonshttpclientV,
    "org.apache.httpcomponents" % "httpcore" % commonshttpcoreV,
    "org.apache.httpcomponents" % "httpmime" % commonshttpclientV,
    "org.apache.ivy" % "ivy" % ivyV,
    "org.apache.logging.log4j" % "log4j-1.2-api" % log4jV,
    "org.apache.logging.log4j" % "log4j-api" % log4jV,
    "org.apache.logging.log4j" % "log4j-core" % log4jV,
    "org.apache.logging.log4j" % "log4j-layout-template-json" % log4jV,
    "org.apache.logging.log4j" % "log4j-slf4j2-impl" % log4jV,
    "org.apache.orc" % "orc-core" % orcV,
    "org.apache.orc" % "orc-format" % "1.0.0",
    "org.apache.orc" % "orc-mapreduce" % orcV,
//  "org.apache.parquet" % "parquet-avro" % parquetV % Test,
//  "org.apache.parquet" % "parquet-column" % parquetV,
//  "org.apache.parquet" % "parquet-column" % parquetV % Test,
//  "org.apache.parquet" % "parquet-common" % parquetV % Test,
//  "org.apache.parquet" % "parquet-encoding" % parquetV % Test,
//  "org.apache.parquet" % "parquet-hadoop" % parquetV,
    "org.apache.thrift" % "libfb303" % "0.9.3",
    "org.apache.thrift" % "libthrift" % libthriftV,
    "org.apache.ws.xmlschema" % "xmlschema-core" % wsxmlschemaV,
    "org.apache.xbean" % "xbean-asm9-shaded" % "4.25",
    "org.apache.zookeeper" % "zookeeper" % zookeeperV,
    "org.bouncycastle" % "bcpkix-jdk18on" % bouncycastleV % Test,
    "org.bouncycastle" % "bcprov-jdk18on" % bouncycastleV % Test,
    "org.codehaus.jackson" % "jackson-core-asl" % codehausjacksonV,
    "org.codehaus.jackson" % "jackson-mapper-asl" % codehausjacksonV,
    "org.codehaus.janino" % "commons-compiler" % "3.1.9",
    "org.codehaus.janino" % "janino" % "3.1.9",
    "org.codehaus.mojo" % "extra-enforcer-rules" % "1.8.0",
    "org.datanucleus" % "datanucleus-core" % datanucleuscoreV,
    "org.eclipse.jetty" % "jetty-client" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-http" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-plus" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-proxy" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-security" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-server" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-servlet" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-servlets" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-util" % jettyV % Provided,
    "org.eclipse.jetty" % "jetty-webapp" % jettyV % Provided,
    "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8",
    "org.glassfish.jaxb" % "jaxb-runtime" % "2.3.2" % Compile,
    "org.glassfish.jaxb" % "txw2" % orgglassfishjaxbtxw2V,
    "org.glassfish.jersey.containers" % "jersey-container-servlet-core" % jerseyV,
    "org.glassfish.jersey.containers" % "jersey-container-servlet" % jerseyV,
    "org.glassfish.jersey.core" % "jersey-client" % jerseyV,
    "org.glassfish.jersey.core" % "jersey-common" % jerseyV,
    "org.glassfish.jersey.core" % "jersey-server" % jerseyV,
    "org.glassfish.jersey.inject" % "jersey-hk2" % jerseyV,
    "org.glassfish.jersey.test-framework.providers" % "jersey-test-framework-provider-simple" % jerseyV % Test,
    "org.jmock" % "jmock-junit5" % "2.13.1" % Test,
    "org.jodd" % "jodd-core" % "3.5.2",
    "org.jpmml" % "pmml-model" % "1.4.8" % Compile,
    "org.jpmml" % "pmml-model" % "1.4.8" % Provided,
    "org.json4s" %% "json4s-jackson" % "4.0.7",
    "org.junit.jupiter" % "junit-jupiter-api" % junitJupiterV % Test,
    "org.junit.jupiter" % "junit-jupiter-engine" % junitJupiterV % Test,
    "org.junit.jupiter" % "junit-jupiter-params" % junitJupiterV % Test,
    "org.junit.jupiter" % "junit-jupiter" % junitJupiterV % Test,
    "org.junit.platform" % "junit-platform-commons" % junitPlatformV % Test,
    "org.junit.platform" % "junit-platform-engine" % junitPlatformV % Test,
    "org.junit.platform" % "junit-platform-launcher" % junitPlatformV % Test,
    "org.lz4" % "lz4-java" % "1.8.0",
    "org.mockito" % "mockito-core" % "5.10.0" % Test,
    "org.mariadb.jdbc" % "mariadb-java-client" % mariadbjavaclientV % Test,
    "org.ow2.asm" % "asm-commons" % asmV,
    "org.ow2.asm" % "asm" % asmV,
    "org.postgresql" % "postgresql" % postgresqlV % Test,
    "org.rocksdb" % "rocksdbjni" % "8.11.4",
    "org.roaringbitmap" % "RoaringBitmap" % "1.1.0",
    "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "2.4.0",
    "org.scala-lang.modules" %% "scala-xml" % "2.3.0",
    "org.scalacheck" %% "scalacheck" % "1.18.0" % Test,
    "org.scalanlp" %% "breeze" % "2.1.0",
    "org.scalatest" %% "scalatest" % "3.2.18" % Test,
    "org.scalatestplus" %% "mockito-5-10" % "3.2.18.0" % Test,
    "org.scalatestplus" %% "scalacheck-1-18" % "3.2.18.0" % Test,
    "org.scalatestplus" %% "selenium-4-17" % "3.2.18.0" % Test,
    "org.seleniumhq.selenium" % "htmlunit3-driver" % htmlunit3driverV % Test,
    "org.seleniumhq.selenium" % "selenium-java" % seleniumV % Test,
    "org.slf4j" % "jcl-over-slf4j" % slf4jV,
    "org.slf4j" % "jul-to-slf4j" % slf4jV,
    "org.slf4j" % "slf4j-api" % slf4jV,
    "org.spark-project.spark" % "unused" % "1.0.0",
    "org.tukaani" % "xz" % "1.9",
    "org.xerial.snappy" % "snappy-java" % snappyV,
    "xerces" % "xercesImpl" % "2.12.2"
  )
)

Global / onChangedBuildSource := ReloadOnSourceChanges

// licenses += ("CC0", url("https://creativecommons.org/publicdomain/zero/1.0/"))
//
// resolvers ++= Seq(
// )
//
// scalacOptions ++= Seq(
//  "-deprecation", // Emit warning and location for usages of deprecated APIs.
//  "-encoding",
//  "utf-8", // Specify character encoding used by source files.
//  "-explaintypes", // Explain type errors in more detail.
//  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
//  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
//  "-language:experimental.macros", // Allow macro definition (besides implementation and application)
//  "-language:higherKinds", // Allow higher-kinded types
//  "-language:implicitConversions", // Allow definition of implicit functions called views
//  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
//  "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
//  "-Xlint:adapted-args", // Warn if an argument list is modified to match the receiver.
//  "-Xlint:constant", // Evaluation of a constant arithmetic expression results in an error.
//  "-Xlint:delayedinit-select", // Selecting member of DelayedInit.
//  "-Xlint:doc-detached", // A Scaladoc comment appears to be detached from its element.
//  "-Xlint:inaccessible", // Warn about inaccessible types in method signatures.
//  "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
//  "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
//  "-Xlint:nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
//  "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
//  "-Xlint:option-implicit", // Option.apply used implicit view.
//  "-Xlint:package-object-classes", // Class or object defined in package object.
//  "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
//  "-Xlint:private-shadow", // A private field (or class parameter) shadows a superclass field.
//  "-Xlint:stars-align", // Pattern sequence wildcard must align with sequence component.
//  "-Xlint:type-parameter-shadow" // A local type parameter shadows a type already in scope.
//)
//
//scalacOptions ++=
//  scalaVersion {
//    case sv if sv.startsWith("2.13") =>
//      List(
//      )
//
//    case sv if sv.startsWith("2.12") =>
//      List(
//        "-Yno-adapted-args", // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
//        "-Ypartial-unification", // Enable partial unification in type constructor inference
//        "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
//        "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
//        "-Ywarn-infer-any", // Warn when a type argument is inferred to be `Any`.
//        "-Ywarn-nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
//        "-Ywarn-nullary-unit", // Warn when nullary methods return Unit.
//        "-Ywarn-numeric-widen" // Warn when numerics are widened.
//      )
//
//    case _ => Nil
//  }.value

lazy val common_tags = crossProject(JVMPlatform)
  .crossType(CrossType.Full)
  .in(file("common/tags"))
  .settings(
    name := "common_tags"
  )
  .jvmSettings(commonJvmSettings)

lazy val common_utils = crossProject(JVMPlatform)
  .crossType(CrossType.Full)
  .in(file("common/utils"))
  .settings(
    name := "common_utils"
  )
  .jvmSettings(commonJvmSettings)
  .dependsOn(common_tags)

lazy val core = crossProject(JVMPlatform)
  .crossType(CrossType.Full)
  .in(file("core"))
  .settings(
    name := "core"
  )
  .jvmSettings(commonJvmSettings)
  .dependsOn(common_tags, common_utils)

//lazy val common_tags project
//    .in(file("common/tags"))
//    .settings(
//      name := "common_tags"
//    )
//    .settings(commonJvmSettings)
//
//lazy val core = crossProject(JVMPlatform)
//  .crossType(CrossType.Pure)
//  .in(file("core"))
//  .settings(
//    name := "core"
//  )

//

compileOrder := CompileOrder.JavaThenScala

// Java then Scala for main sources
//Compile / compileOrder := CompileOrder.JavaThenScala
//Compile / compileOrder := CompileOrder.Mixed

// allow circular dependencies for test sources
//Test / compileOrder := CompileOrder.Mixed
