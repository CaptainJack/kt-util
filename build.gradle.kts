plugins {
	kotlin("multiplatform") version "1.3.41"
	id("nebula.release") version "11.1.0"
	id("ru.capjack.bintray") version "0.19.0"
}

group = "ru.capjack.tool"

repositories {
	jcenter()
}

kotlin {
	
	jvm {
		compilations.all { kotlinOptions.jvmTarget = "1.8" }
	}
	js {
		compilations["main"].kotlinOptions {
			sourceMap = true
			sourceMapEmbedSources = "always"
		}
	}
	
	sourceSets {
		get("commonMain").dependencies {
			implementation(kotlin("stdlib-common"))
		}
		
		get("jvmMain").dependencies {
			implementation(kotlin("stdlib-jdk8"))
		}
		
		get("jsMain").dependencies {
			implementation(kotlin("stdlib-js"))
		}
	}
}
