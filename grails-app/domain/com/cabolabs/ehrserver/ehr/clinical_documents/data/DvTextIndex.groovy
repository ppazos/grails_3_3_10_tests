package com.cabolabs.ehrserver.ehr.clinical_documents.data

class DvTextIndex extends DataValueIndex {

    String value

    static constraints = {
        value(maxSize: 16777215) //16MB
    }
}
