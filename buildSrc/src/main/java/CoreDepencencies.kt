import Versions.DAGGER_VERSION
import Versions.MOSHI_VERSION
import Versions.OKHTTP_VERSION
import Versions.RETROFIT_COROUTINES_ADAPTER_VERSION
import Versions.RETROFIT_VERSION

object CoreDepencencies {
  const val dagger = "com.google.dagger:dagger:$DAGGER_VERSION"
  const val daggerCompiler = "com.google.dagger:dagger-compiler:$DAGGER_VERSION"
  const val retrofit = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
  const val moshi = "com.squareup.moshi:moshi:$MOSHI_VERSION"
  const val okhttp = "com.squareup.okhttp3:okhttp:$OKHTTP_VERSION"
  const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"
  const val retrofitCoroutinesAdapter =
    "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:$RETROFIT_COROUTINES_ADAPTER_VERSION"
}
