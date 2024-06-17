pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.fabricmc.net/")
        maven("https://repo.legacyfabric.net/repository/legacyfabric/")
    }
    plugins {
        val loomVersion = "1.6-SNAPSHOT"
        id("fabric-loom") version loomVersion
        id("legacy-looming") version loomVersion
    }
}

rootProject.name = "legacy-guava"

