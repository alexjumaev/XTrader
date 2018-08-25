package com.sedsoftware.binance.parsing

import com.sedsoftware.binance.fakedata.FakeTradesData
import com.winterbe.expekt.should
import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.CachingMode
import org.spekframework.spek2.style.specification.describe

class TradesParsingTest : Spek({

    describe("Symbol trades parser") {

        val fakeDataSource by memoized(CachingMode.SCOPE) { FakeTradesData() }

        context("Parsing json") {
            val parsedList = fakeDataSource.getRawParsedData()

            it("Should return correct list") {
                parsedList.should.equal(fakeDataSource.getPredefinedParsedList())
            }
        }
    }
})