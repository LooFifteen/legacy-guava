plugins {
    id("fabric-loom")
    id("legacy-looming")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    `maven-publish`
}

val mod_version: String by project.properties
val maven_group: String by project.properties
val minecraft_version: String by project.properties
val yarn_mappings: String by project.properties
val loader_version: String by project.properties
val archives_base_name: String by project.properties

version = mod_version
group = maven_group

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
}

base {
    archivesName = archives_base_name
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    maven("https://pkgs.dev.azure.com/djtheredstoner/DevAuth/_packaging/public/maven/v1/")
}

dependencies {
    minecraft("com.mojang:minecraft:${minecraft_version}")
    mappings(legacy.yarn(minecraft_version, yarn_mappings))
    modImplementation("net.fabricmc:fabric-loader:$loader_version")

    shadow(implementation("com.google.guava:guava:33.2.1-jre")!!)

    // dev env
    modRuntimeOnly("me.djtheredstoner:DevAuth-fabric:1.2.1")
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
}

tasks {
    withType<ProcessResources> {
        inputs.property("verison", mod_version)

        filesMatching("fabric.mod.json") {
            expand(mapOf("version" to mod_version))
        }
    }

    shadowJar {
        configurations = listOf(project.configurations.shadow.get())

        dependencies {
            exclude(dependency("com.google.errorprone:error_prone_annotations"))
            exclude(dependency("org.checkerframework:checker-qual"))
            exclude(dependency("com.google.code.findbugs:jsr305"))
        }
    }

    remapJar {
        dependsOn(shadowJar)
        inputFile.set(shadowJar.get().archiveFile)
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = archives_base_name
            from(components["java"])
        }
    }

    repositories {
        mavenLocal()
    }
}