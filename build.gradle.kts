fun properties(key:String) = project.findProperty(key).toString()

plugins {
    id("java")
    id("org.jetbrains.intellij") version "0.7.3"
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
}

apply{
    plugin("org.jetbrains.intellij")
    plugin("idea")
}

//group("io.xmake")
//version("1.0.6")
group = properties("pluginGroup")
version = properties("pluginVersion")

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
/*
intellij {
    type "C"L
    version = "CL-2021.1.2"
    downloadSources false
    plugins = ["com.intellij.cidr.base", "com.intellij.clion"]
}*/

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName("buildSearchableOptions").enabled = false

/*
runPluginVerifier {
    ideVersions(["IC-2018.1.8", "CL-2021.2"])
    verifierPath("/home/filter-x/Downloads/Programs/verifier-cli-1.266-all.jar")
    localPaths(["/home/filter-x/program/clion-2021.1.3","/home/filter-x/program/idea-IC-211.7628.21"])
    runtimeDir("/usr/lib/jvm/java-11-openjdk-amd64")
}*/
