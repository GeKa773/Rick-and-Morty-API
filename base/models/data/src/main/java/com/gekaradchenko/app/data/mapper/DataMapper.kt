package com.gekaradchenko.app.data.mapper

import com.gekaradchenko.app.data.BaseDataCollectionModel
import com.gekaradchenko.app.data.DataResponse
import com.gekaradchenko.app.domain.BaseDomainCollectionResult
import com.gekaradchenko.app.domain.DomainResponse

internal fun <DATA, DOMAIN> DataResponse<DATA>.toDataResponse(mapper: (DATA) -> DOMAIN): DomainResponse<DOMAIN> =
    DomainResponse(
        isSuccessful = this.isSuccessful,
        code = this.code,
        message = this.message,
        body = if (this.body == null) null else mapper(this.body),
    )

internal fun <DATA, DOMAIN> BaseDataCollectionModel<DATA>.toDataCollectionModel(mapper: (DATA) -> DOMAIN): BaseDomainCollectionResult {
    return BaseDomainCollectionResult(
        count = this.info.count,
        pages = this.info.pages,
        next = this.info.next,
        prev = this.info.prev,
    )
}