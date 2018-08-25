package com.sedsoftware.binance.mapper

import com.sedsoftware.binance.database.model.BinanceSymbolDbModel
import com.sedsoftware.binance.fakedata.FakeInfoData
import com.winterbe.expekt.should
import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.CachingMode
import org.spekframework.spek2.style.specification.describe
import java.util.Date

class BinanceSymbolsMapperTest : Spek({

    describe("Symbol info mapper") {

        val timestamp = Date().time

        val mapper by memoized { BinanceSymbolsMapper() }
        val fakeDataSource by memoized(CachingMode.SCOPE) { FakeInfoData() }

        val parsedDto = fakeDataSource.getPredefinedParsedDto()

        lateinit var mappedDbEntities: List<BinanceSymbolDbModel>

        context("Mapping from parsed cloud to db") {
            mappedDbEntities = parsedDto.symbols.map { mapper.mapFromCloudToDb(it, timestamp) }

            it("should return correct value") {
                mappedDbEntities.should.equal(fakeDataSource.getDatabaseEntities(timestamp))
            }
        }

        context("Mapping base currencies to domain") {
            val mappedDomainEntities = mapper.mapBaseSymbolsFromDb(mappedDbEntities)

            it("should return correct values") {
                mappedDomainEntities.should.equal(fakeDataSource.getBaseSymbolsDomainEntities())
            }
        }

        context("Mapping currency pairs to domain") {
            val mappedDomainPairs = mapper.mapMarketPairsFromDb(mappedDbEntities)

            it("should return correct values") {
                mappedDomainPairs.should.equal(fakeDataSource.getCurrencyPairDomainEntities())
            }
        }
    }
})
