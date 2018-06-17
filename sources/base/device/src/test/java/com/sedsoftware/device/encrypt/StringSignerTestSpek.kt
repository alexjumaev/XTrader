package com.sedsoftware.device.encrypt

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class StringSignerTestSpek : Spek({

  given("String signer") {

    val signer by memoized { SignerImpl() }

    context("with given key") {

      val signKey = "thisismysupersecurekey"

      mapOf(
        "test" to "cc04a33744447f7897d0e24ba9898ab2ce807afe",
        "limit=10" to "c6b3514b77dd9d045e5fe189070666ca0783c45d",
        "HelloWorld" to "b6a489d7abed9c29897355cc420633b43bdb8938"
      ).forEach { (text, signedText) ->

        on("signing with sha1") {
          val signedString by memoized { signer.signWithSha1(text, signKey) }

          it("should return correct string") {
            signedString.should.equal(signedText)
          }
        }
      }

      mapOf(
        "test" to "066a5aa77848f69f96b89ed1260e1cfa845d3c3b6c0e56c781472359761cd56a",
        "limit=10" to "844bd7866deca6e0ebdb4e422c6e1b717e6b4c4ab283b5cb7969705cc31a8477",
        "HelloWorld" to "9bbd2570d947c309f4386159ff8aad0296de815a3ba14763a4d93890d1be7214"
      ).forEach { (text, signedText) ->

        on("signing with sha256") {
          val signedString by memoized { signer.signWithSha256(text, signKey) }

          it("should return correct string") {
            signedString.should.equal(signedText)
          }
        }
      }
    }
  }
})