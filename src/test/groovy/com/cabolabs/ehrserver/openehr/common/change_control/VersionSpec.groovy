package com.cabolabs.ehrserver.openehr.common.change_control


import spock.lang.Specification

import com.cabolabs.ehrserver.openehr.ehr.EhrStatus
import com.cabolabs.ehrserver.openehr.common.generic.*
import com.cabolabs.ehrserver.ehr.clinical_documents.data.DvTextIndex


// The default unit test for the domain class implements DomainUnitTest<Domain>,
// but if other domain classes are involved, it won't work giving an NPE somewhere in the .save()
// Extending DataTest (see https://testing.grails.org/latest/guide/index.html#unitTestingDomainClasses)
// allows to mock other domains and the test runs without problems
import grails.testing.gorm.DataTest

// run only this:
// $ grails test-app com.cabolabs.ehrserver.openehr.common.change_control.VersionSpec -unit

class VersionSpec extends Specification implements DataTest { //DomainUnitTest<Version> {

    def setup()
    {
        mockDomain Version
        mockDomain EhrStatus
        mockDomain AuditDetails
        mockDomain PartyProxy

        def v = new Version(
            uid: '123',
            lifecycleState: '532',
            data: new EhrStatus(
                uid: '333',
                archetypeId: 'openEHR-EHR-EHR_STATUS.test.v1',
                templateId: 'ehr_status.en.v1',
                isModifiable: true,
                isQueryable: true,
                    dvTextIndex: new DvTextIndex(
                    value:                "EHR Status",
                    templateId:           "default_ehr_status.en.v1",
                    archetypeId:          "openEHR-EHR-EHR_STATUS.generic.v1",
                    path:                 "/name",
                    archetypePath:        "/name",
                    owner:                null,
                    rmTypeName:           'DV_TEXT',
                    instanceTemplatePath: "/name"
                )
            ),
            commitAudit: new AuditDetails(
                systemId: 'test',
                timeCommitted: new Date(),
                committer: new PartyProxy(
                    value: '556',
                    name: 'Jose Perez'
                )
            )
        )

        if (!v.save())
        {
            println v.errors
        }
    }

    def cleanup()
    {
    }

    void "test one version"()
    {
        expect: "one version"
            Version.count() == 1
    }
}
