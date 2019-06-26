plugins {
	kotlin("multiplatform") version "1.3.40"
	id("nebula.release") version "10.1.2"
	id("ru.capjack.bintray") version "0.17.0"
}

group = "ru.capjack.tool"

repositories {
	jcenter()
}

kotlin {
	sourceSets {
		commonMain.get().dependencies {
			implementation(kotlin("stdlib-common"))
		}
	}
	
	jvm().compilations {
		get("main").defaultSourceSet.dependencies {
			implementation(kotlin("stdlib-jdk8"))
		}
	}
	
	js().compilations {
		get("main").defaultSourceSet.dependencies {
			implementation(kotlin("stdlib-js"))
		}
	}
}
