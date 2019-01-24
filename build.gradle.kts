import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation.Companion.MAIN_COMPILATION_NAME

plugins {
	kotlin("multiplatform") version "1.3.20"
	id("nebula.release") version "9.2.0"
	id("ru.capjack.capjack-bintray") version "0.14.1"
}

group = "ru.capjack.kt.utils"

repositories {
	jcenter()
}

kotlin {
	
	jvm {
		compilations.all {
			kotlinOptions {
				jvmTarget = "1.8"
			}
		}
	}
	
	js {
		compilations.all {
			kotlinOptions {
				sourceMap = true
				sourceMapEmbedSources = "always"
				moduleKind = "umd"
			}
		}
	}
	
	sourceSets {
		commonMain {
			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}
		
		jvm().compilations[MAIN_COMPILATION_NAME].defaultSourceSet {
			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}
		
		js().compilations[MAIN_COMPILATION_NAME].defaultSourceSet {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}
	}
	
}