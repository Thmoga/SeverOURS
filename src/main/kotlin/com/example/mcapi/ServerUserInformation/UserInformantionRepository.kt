package com.example.mcapi.ServerUserInformation

import org.springframework.data.jpa.repository.JpaRepository

interface UserInformationRepository : JpaRepository<UserInformation, String>
