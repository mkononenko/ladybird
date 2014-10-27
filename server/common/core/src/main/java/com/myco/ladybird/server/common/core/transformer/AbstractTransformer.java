package com.myco.ladybird.server.common.core.transformer;

import com.myco.ladybird.server.common.core.dto.Dto;
import com.myco.ladybird.server.common.core.model.Model;

/**
 *
 * @author mkononenko
 */
public abstract class AbstractTransformer<M extends Model, D extends Dto> implements Transformer<M, D> {

    protected abstract D createDto();

    protected abstract D buildDto(D dto, M model);

    protected abstract M createModel();

    protected abstract M buildModel(M model, D dto);

    @Override
    public D toDto(M model) {
        D dto = createDto();
        dto = buildDto(dto, model);
        return dto;
    }

    @Override
    public M toModel(D dto) {
        M model = createModel();
        model = buildModel(model, dto);
        return model;
    }
}
