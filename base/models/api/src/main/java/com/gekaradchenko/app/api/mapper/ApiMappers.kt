package com.gekaradchenko.app.api.mapper

import com.gekaradchenko.app.api.BaseApiCollectionModel
import com.gekaradchenko.app.api.InfoDTO
import com.gekaradchenko.app.data.BaseDataCollectionModel
import com.gekaradchenko.app.data.DataResponse
import com.gekaradchenko.app.data.InfoData
import retrofit2.Response

internal fun <DTO, DATA> Response<DTO>.toDataResponse(mapper: (DTO) -> DATA): DataResponse<DATA> =
    DataResponse(
        isSuccessful = isSuccessful,
        code = code(),
        message = message(),
        body = if (body() == null) null else mapper(body()!!),
    )


internal fun <DTO, DATA> BaseApiCollectionModel<DTO>.toDataCollectionModel(mapper: (DTO) -> DATA): BaseDataCollectionModel<DATA> {
    return BaseDataCollectionModel(
        info = this.info.toData(),
        result = this.result.map(mapper)
    )
}

private fun InfoDTO.toData(): InfoData {
    return InfoData(
        count = this.count,
        pages = this.pages,
        next = this.next,
        prev = this.prev,
    )
}