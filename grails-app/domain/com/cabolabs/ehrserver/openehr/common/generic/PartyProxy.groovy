package com.cabolabs.ehrserver.openehr.common.generic

import com.cabolabs.ehrserver.ehr.clinical_documents.data.DvIdentifierIndex
import com.cabolabs.ehrserver.ehr.clinical_documents.data.DvCodedTextIndex

class PartyProxy {

    // Emula PARTY_PROXY.external_ref.namespace
    // La referencia (id) es valida localmente
    String namespace = "demographic"

    // Emula PARTY_PROXY.external_ref.type
    // References an external PERSON record
    String type = "PERSON"

    // Identificador confiable del medico (no es su cedula, documento o pasaporte), es asignado por el sistema al crear el doctor
    // Emula PARTY_PROXY.external_ref.id<OBJECT_ID>.value
    // Que a su vez emula un HIER_OBJECT_ID.root y su valor va a ser un UUID (java.util.UUID.randomUUID() as String)
    String value

    // PARTY_PROXY.external_ref.id<GENERIC_ID>.scheme
    String scheme

    // PARTY_IDENTIFIED.name
    String name

    // GENERIC_ID, HIER_OBJECT_ID
    String id_type = "HIER_OBJECT_ID"

    // PARTY_IDENTIFIED.identifiers
    static hasMany = [identifiers: DvIdentifierIndex]

    // TODO: add this field to the data indexing and search
    // PARTY_RELATED.relatioship
    DvCodedTextIndex relatioship

    static constraints = {
        namespace   nullable: true
        type        nullable: true
        id_type     nullable: true
        value       nullable: true
        scheme      nullable: true
        name        nullable: false
        relatioship nullable: true
    }
}
