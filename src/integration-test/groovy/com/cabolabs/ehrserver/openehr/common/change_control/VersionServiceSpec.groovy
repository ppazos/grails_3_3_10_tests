package com.cabolabs.ehrserver.openehr.common.change_control

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VersionServiceSpec extends Specification {

    VersionService versionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Version(...).save(flush: true, failOnError: true)
        //new Version(...).save(flush: true, failOnError: true)
        //Version version = new Version(...).save(flush: true, failOnError: true)
        //new Version(...).save(flush: true, failOnError: true)
        //new Version(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //version.id
    }

    void "test get"() {
        setupData()

        expect:
        versionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Version> versionList = versionService.list(max: 2, offset: 2)

        then:
        versionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        versionService.count() == 5
    }

    void "test delete"() {
        Long versionId = setupData()

        expect:
        versionService.count() == 5

        when:
        versionService.delete(versionId)
        sessionFactory.currentSession.flush()

        then:
        versionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Version version = new Version()
        versionService.save(version)

        then:
        version.id != null
    }
}
