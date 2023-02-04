package com.pdmpa.stockmarketapp.data.remote

import com.pdmpa.stockmarketapp.data.remote.dto.CompanyInfoDto
import com.pdmpa.stockmarketapp.domain.model.NewsDto
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = "WBYPBRI3B2MT7Z79"
    ): ResponseBody

    @GET("query?function=TIME_SERIES_INTRADAY&interval=60min&datatype=csv")
    suspend fun getIntradayInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = "WBYPBRI3B2MT7Z79"
    ): ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = "WBYPBRI3B2MT7Z79"
    ): CompanyInfoDto

    @GET("v1/news/{filter}")
    suspend fun getNews(
        @Path("filter") filter: String,
        /**
         * available filters
         * 1. handpicked
         * 2. trending
         * 3. latest
         * 4. bullish
         * 5. bearish
         */
        @Query("limit") limit: Int = 20,
        @Query("skip") skip: Int = 0
    ): NewsDto

    companion object {
        const val BASE_URL = "https://alphavantage.co"
        const val NEWS_BASE_URL = "https://api.coinstats.app/public/"
    }
}