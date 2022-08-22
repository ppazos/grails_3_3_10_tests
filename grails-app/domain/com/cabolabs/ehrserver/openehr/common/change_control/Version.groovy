package com.cabolabs.ehrserver.openehr.common.change_control

import com.cabolabs.ehrserver.openehr.common.archetyped.Locatable
import com.cabolabs.ehrserver.openehr.common.generic.AuditDetails

class Version {

    String uid
    String lifecycleState
    Locatable data
    AuditDetails commitAudit

    static constraints = {
        lifecycleState      inList: ['532', '553', '523']
        data                nullable: true
    }
}
