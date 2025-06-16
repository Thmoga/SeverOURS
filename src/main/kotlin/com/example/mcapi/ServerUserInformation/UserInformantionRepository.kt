package com.example.mcapi.ServerUserInformation

import org.springframework.data.jpa.repository.JpaRepository

interface UserInformantionRepository : JpaRepository<UserInformation, String>
