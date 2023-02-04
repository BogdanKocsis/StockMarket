package com.pdmpa.stockmarketapp.data.repository

import com.pdmpa.stockmarketapp.data.remote.StockApi
import com.pdmpa.stockmarketapp.domain.model.NewsDto
import com.pdmpa.stockmarketapp.domain.repository.NewsRepository

class NewsRepositoryImpl(private val api: StockApi) : NewsRepository {

    override suspend fun getNews(filter: String): NewsDto {
        return api.getNews(filter)
    }

}
