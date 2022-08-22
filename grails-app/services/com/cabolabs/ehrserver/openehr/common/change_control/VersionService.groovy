package com.cabolabs.ehrserver.openehr.common.change_control

import grails.gorm.services.Service

@Service(Version)
interface VersionService {

    Version get(Serializable id)

    List<Version> list(Map args)

    Long count()

    void delete(Serializable id)

    Version save(Version version)

}