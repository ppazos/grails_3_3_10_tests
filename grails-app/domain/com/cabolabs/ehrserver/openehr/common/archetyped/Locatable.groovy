package com.cabolabs.ehrserver.openehr.common.archetyped

import com.cabolabs.ehrserver.ehr.clinical_documents.data.DvTextIndex

class Locatable {

    String uid

    String archetypeId
    String templateId

    Date validUntil
    boolean lastVersion = true

    DvTextIndex dvTextIndex

    static mapping = {
      tablePerHierarchy false
   }

   static constraints = {
      validUntil nullable: true
   }
}
