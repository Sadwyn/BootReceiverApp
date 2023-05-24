package com.example.bootreceiverapp.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val dao: BootDAO
) {

    fun getBoots(): List<BootModel> {
        return dao.getAll()
    }

    fun insertBoot(bootModel: BootModel) {
        dao.insert(bootModel)
    }
}