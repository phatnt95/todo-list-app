package io.github.phatnt95.todolistapp.service.user;

import io.github.phatnt95.todolistapp.entity.Role;
import io.github.phatnt95.todolistapp.service.GenaralService;

/**
 * @author phatnt
 * @discription
 */
public interface RoleService extends GenaralService<Role> {
    Role findByName(String name);
}
