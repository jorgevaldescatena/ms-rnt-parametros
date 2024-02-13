package com.mtt.rnt.services;

import java.util.List;
import java.util.Map;

public interface GenericService<T> {

    String getSQLQuery();

    /**
     * Obtiene la cantidad de registros en la entidad
     *
     * @return cantidad de registros
     */
    Long getDataCount();

    /**
     * Obtiene la cantidad de registros en la entidad, según los criterios de busqueda
     *
     * @param criteria criterios de busqueda
     * @return cantidad de registros
     */
    Long getDataCount(Map<String, Map<String, Object>> criteria);

    /**
     * Obtiene la cantidad de registros en la entidad, según los criterios de busqueda simples y opcionales
     * @param simpleCriteria Criterios de busqueda simples
     * @param optionalsCriteria Criterios de busqueda opcionales
     * @return cantidad de registros
     */
    Long getDataCount(Map<String, Object> simpleCriteria, List<Map<String, Object>> optionalsCriteria);

}
