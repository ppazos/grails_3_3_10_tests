package com.cabolabs.ehrserver.ehr.clinical_documents.data

class DataValueIndex {

    String templateId
    String archetypeId
    String path
    String archetypePath
    String rmTypeName

    static constraints = {
    }

    static mapping = {
      tablePerHierarchy false
   }
}
