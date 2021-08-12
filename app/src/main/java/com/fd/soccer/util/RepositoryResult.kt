package com.fd.soccer.util

data class RepositoryResult<out T>(val status: Status?, val throwable: Throwable?, val data: T?) {

    companion object {

        fun <T> success(data: T?): RepositoryResult<T> {
            return RepositoryResult(Status.SUCCESS, null, data)
        }

        fun <T> error(throwable: Throwable?, data: T? = null): RepositoryResult<T> {
            return RepositoryResult(Status.ERROR, throwable, data)
        }

    }

}