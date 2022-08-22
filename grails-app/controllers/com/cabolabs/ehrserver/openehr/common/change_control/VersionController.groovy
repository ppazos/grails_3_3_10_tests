package com.cabolabs.ehrserver.openehr.common.change_control

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import com.cabolabs.ehrserver.openehr.ehr.EhrStatus
import com.cabolabs.ehrserver.openehr.common.generic.*
import com.cabolabs.ehrserver.ehr.clinical_documents.data.DvTextIndex

class VersionController {

    VersionService versionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond versionService.list(params), model:[versionCount: versionService.count()]
    }

    def show(Long id) {
        respond versionService.get(id)
    }

    def create() {
        respond new Version(params)
    }

    def testCreate()
    {
        def v = new Version(
            uid: '123',
            lifecycleState: '532',
            data: new EhrStatus(
                uid: '333',
                archetypeId: 'openEHR-EHR-EHR_STATUS.test.v1',
                templateId: 'ehr_status.en.v1',
                isModifiable: true,
                isQueryable: true,
                name: new DvTextIndex(
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

    def save(Version version) {
        if (version == null) {
            notFound()
            return
        }

        try {
            versionService.save(version)
        } catch (ValidationException e) {
            respond version.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'version.label', default: 'Version'), version.id])
                redirect version
            }
            '*' { respond version, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond versionService.get(id)
    }

    def update(Version version) {
        if (version == null) {
            notFound()
            return
        }

        try {
            versionService.save(version)
        } catch (ValidationException e) {
            respond version.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'version.label', default: 'Version'), version.id])
                redirect version
            }
            '*'{ respond version, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        versionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'version.label', default: 'Version'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'version.label', default: 'Version'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
