package com.cabolabs.ehrserver.openehr.ehr

import com.cabolabs.ehrserver.openehr.common.archetyped.Locatable

class EhrStatus extends Locatable {

    boolean isModifiable = true
    boolean isQueryable = true

    static constraints = {
    }
}
