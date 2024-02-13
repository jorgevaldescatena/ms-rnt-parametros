package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.repository.GenericRepository;
import com.mtt.rnt.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class GenericServiceImpl<T> implements GenericService<T> {

    @Autowired
    GenericRepository<T> genericRepository;

    @Override
    public String getSQLQuery() {
        return null;
    }

    @Override
    public Long getDataCount() {
        return genericRepository.count();
    }

    @Override
    public Long getDataCount(Map<String, Map<String, Object>> criteria) {
        Specification<T> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            criteria.forEach((field, params) -> {
                String operation = (String) params.get("operation");
                Object value = params.get("value");

                switch (operation) {
                    case "==":
                        predicates.add(criteriaBuilder.equal(root.get(field), value));
                        break;
                    case "!=":
                        predicates.add(criteriaBuilder.notEqual(root.get(field), value));
                        break;
                    case "<":
                        predicates.add(criteriaBuilder.lessThan(root.get(field), (Comparable) value));
                        break;
                    case ">":
                        predicates.add(criteriaBuilder.greaterThan(root.get(field), (Comparable) value));
                        break;
                    case "<=":
                        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(field), (Comparable) value));
                        break;
                    case ">=":
                        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(field), (Comparable) value));
                        break;
                    case "C":
                        predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get(field)), "%" + value.toString().toUpperCase() + "%"));
                        break;
                    case "NC":
                        predicates.add(criteriaBuilder.notLike(criteriaBuilder.upper(root.get(field)), "%" + value.toString().toUpperCase() + "%"));
                        break;
                    case "IN":
                        if (value instanceof Collection) {
                            predicates.add(root.get(field).in((Collection<?>) value));
                        } else {
                            System.err.println("Error: el valor para la operación 'IN' debe ser una colección.");
                        }
                        break;
                }
            });
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return genericRepository.count(specification);
    }

    @Override
    public Long getDataCount(Map<String, Object> simpleCriteria, List<Map<String, Object>> optionalsCriteria) {
        Specification<T> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (simpleCriteria != null) {
                simpleCriteria.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
            }
            if (optionalsCriteria != null) {
                for (Map<String, Object> optionalCriteria : optionalsCriteria) {
                    String field = (String) optionalCriteria.get("field");
                    Object value = optionalCriteria.get("value");
                    predicates.add(criteriaBuilder.equal(root.get(field), value));
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return (Long) genericRepository.count(specification);
    }
}
