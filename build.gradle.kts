plugins {
    id("fabric-loom") version "1.7-SNAPSHOT"
}

val modVersion: String by extra
val minecraftVersion: String by extra
val loaderVersion: String by extra
val fabricApiVersion: String by extra

version = modVersion
group = "dev.tonimatas"

base.archivesName.set("Ethylene")


loom {
    splitEnvironmentSourceSets()

    mods {
        create("ethylene") {
            sourceSet(sourceSets.main.get())
        }
    }
}

repositories {
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")

    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion")
    
    implementation("org.spigotmc:spigot-api:1.21-R0.1-SNAPSHOT")
}

tasks.withType<ProcessResources> {
    val properties = mapOf("version" to version, "minecraftVersion" to minecraftVersion, "loaderVersion" to loaderVersion)
    
    inputs.properties(properties)
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
        expand(properties)
    }
}

val targetJavaVersion = 21
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(targetJavaVersion)
}

java {
    withSourcesJar()
}
