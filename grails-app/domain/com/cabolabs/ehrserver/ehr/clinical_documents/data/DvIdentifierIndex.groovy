package com.cabolabs.ehrserver.ehr.clinical_documents.data

class DvIdentifierIndex {

    String identifier // needed to change the DV_IDENTIFIER.id attr name to identifier because it is used by grails for the identity.
    String type
    String issuer
    String assigner
    
    static constraints = {
    }
}
