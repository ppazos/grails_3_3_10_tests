package com.cabolabs.ehrserver.openehr.common.generic

class AuditDetails {

    // Identificador del sistema al que fue commiteado el cambio en el EHR
    String systemId = 'default_system_id'
    
    // Lo establece el servidor cuando recibe un commit
    Date timeCommitted

    PartyProxy committer

    static constraints = {
    }
}
