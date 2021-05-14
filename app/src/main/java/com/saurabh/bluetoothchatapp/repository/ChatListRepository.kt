package com.saurabh.bluetoothchatapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.saurabh.bluetoothchatapp.database.MyDao
import com.saurabh.bluetoothchatapp.devices.BLDevice
import com.saurabh.bluetoothchatapp.mapper.ChatListMapper
import javax.inject.Inject

class ChatListRepository @Inject constructor(private val dao: MyDao) {

    @Inject
    lateinit var chatLisMapper: ChatListMapper

    fun getConnectedDevices(): LiveData<List<BLDevice?>> {
        val connectedDevices = dao.getConnectedDevices()
        return connectedDevices.map { chatLisMapper.mapFromEntityList(it) }
    }

    fun insertConnectedDevice(blDevice: BLDevice) {
        val device = chatLisMapper.mapToEntity(blDevice)
        dao.insertConnectedDevices(device)
    }
}