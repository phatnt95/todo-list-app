package io.github.phatnt95.todolistapp.dto;

import io.github.phatnt95.todolistapp.entity.User;

/**
 * @author phatnt
 * @discription
 */
public interface GeneralDto<T, G> {
    T entity2model(G g);
    G model2entity(T t);
}
