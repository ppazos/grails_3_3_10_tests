package com.cabolabs.ehrserver.openehr.common.generic

class PatientProxy {

    // Emula PARTY_PROXY.external_ref.namespace
    // La referencia (id) es valida localmente
    String namespace = "local"
    
    // Emula PARTY_PROXY.external_ref.type
    // References to an exteral PERSON record
    String type = "PERSON"
    
    // Identificador confiable del paciente (no es su cedula, documento o pasaporte), es asignado por el sistema al crear el paciente
    // Emula PARTY_PROXY.external_ref.id<OBJECT_ID>.value
    // Que a su vez emula un HIER_OBJECT_ID.root y su valor va a ser un UUID (java.util.UUID.randomUUID() as String)
    String value

    // Only used if the external_ref.id is GENERIC_ID
    String scheme
    
    static constraints = {
        scheme nullable: true
    }
}
