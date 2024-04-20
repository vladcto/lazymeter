package com.vladcto.lazymeter.data.lazy.repository

import com.vladcto.lazymeter.data.lazy.domain.LazyReason
import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import com.vladcto.lazymeter.data.lazy.infra.LazyReasonDb
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDb

internal fun LazyUnit.toDb(): LazyUnitDb = LazyUnitDb(
    time = this.time,
    reason = LazyReasonDb.valueOf(this.reason.name),
)

internal fun LazyUnitDb.toDomain(): LazyUnit = LazyUnit(
    time = this.time,
    reason = LazyReason.valueOf(this.reason.name),
)

