package com.myco.ladybird.server.common.core.transformer;

import com.myco.ladybird.server.common.core.dto.Dto;
import com.myco.ladybird.server.common.core.model.Model;

/**
 *
 * @author mkononenko
 */
public interface Transformer<M extends Model, D extends Dto> {

    D toDto(M model);

    M toModel(D dto);
}
