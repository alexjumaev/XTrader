apply plugin: 'com.android.library'

<#if generateKotlin>
apply plugin: 'kotlin-android'

apply plugin: 'kotlin-kapt'
</#if>

android {
    compileSdkVersion 27
    defaultConfig {
        minSdkVersion 21
        targetSdkVersion 27
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    ${getConfigurationName("implementation")} fileTree(dir: 'libs', include: ['*.jar'])

<#if generateKotlin>
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
</#if>

    implementation "com.google.dagger:dagger:2.17"
<#if generateKotlin>
    kapt "com.google.dagger:dagger-compiler:2.17"
<#else>
    annotationProcessor "com.google.dagger:dagger-compiler:2.17"
</#if>
}
