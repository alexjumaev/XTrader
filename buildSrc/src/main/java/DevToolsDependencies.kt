import Versions.LEAK_CANARY_VERSION
import Versions.STETHO_VERSION
import Versions.TIMBER_VERSION

object DevToolsDependencies {
    const val timber = "com.jakewharton.timber:timber:$TIMBER_VERSION"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:$LEAK_CANARY_VERSION"
    const val stetho = "com.facebook.stetho:stetho:$STETHO_VERSION"
}
