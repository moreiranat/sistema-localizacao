package io.github.moreiranat.localizacao.domain.repository.specs;

import io.github.moreiranat.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> propertyEqual(String prop, Object value) {
        return (root, query, cb) -> cb.equal(root.get(prop), value);
    }

    public static Specification<Cidade> idEqual(Long id) {
        return (root, query, cb) -> cb.equal(root.get("nome"), id);
    }

    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, cb) -> cb.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> habitantesGreaterThan(Integer value) {
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), value);
    }
}
