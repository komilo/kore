/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.web.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tg.komilo.kore.entities.Permission;
import tg.komilo.kore.entities.PermissionCategory;
import tg.komilo.kore.entities.Role;
import tg.komilo.kore.service.GenericServiceBeanRemote;
import tg.komilo.kore.service.PermissionCategoryServiceBeanRemote;
import tg.komilo.kore.service.PermissionServiceBeanRemote;
import tg.komilo.kore.service.RoleServiceBeanRemote;
import tg.komilo.kore.utils.KoreConstants;
import tg.komilo.kore.utils.SortDirection;
import tg.komilo.kore.utils.SortParams;

/**
 *
 * @author komilo
 */
@ManagedBean
@ViewScoped
public class RoleBean extends GenericBean<Role, Long> {

    @EJB
    private RoleServiceBeanRemote roleService;

    @EJB
    private PermissionCategoryServiceBeanRemote permissionCategoryService;

    @EJB
    private PermissionServiceBeanRemote permissionService;
    
    private final Map<String, Boolean> checkMap = new HashMap<>();

    public RoleBean() {
        super();
    }

    @PostConstruct
    @Override
    public void init() {
        super.init();
        this.entity = new Role();
    }

    @Override
    public void initUpdate() {
        super.initUpdate();
        for (Permission permission : this.entity.getPermissions()) {
            this.checkMap.put(permission.getCode(), Boolean.TRUE);
        }
    }

    @Override
    public GenericServiceBeanRemote<Role, Long> getService() {
        return this.roleService;
    }

    public List<PermissionCategory> getPermissionCategories() {
        return this.permissionCategoryService.getAll(SortParams.from("label", SortDirection.ASCENDING));
    }

    public List<Permission> getPermissions(PermissionCategory category) {
        return this.permissionService.getAll(category);
    }

    @Override
    public void beforeAdd() {
        super.beforeAdd();
        this.updateSelectedPermissions();
    }

    @Override
    public void beforeUpdate() {
        super.beforeUpdate();
        this.updateSelectedPermissions();
    }
    
    private void updateSelectedPermissions() {
        for (Map.Entry<String, Boolean> entry : this.checkMap.entrySet()) {
            if (entry.getValue()) {
                this.entity.getPermissions().add(this.permissionService.getOne(entry.getKey()));
            }
        }
    }

    @Override
    public boolean canAdd() {
        return this.userService.isPermitted(KoreConstants.PERM_SECURITY_ROLE_ADD);
    }

    @Override
    public boolean canUpdate() {
        return this.userService.isPermitted(KoreConstants.PERM_SECURITY_ROLE_EDIT);
    }

    @Override
    public boolean canDelete() {
        return this.userService.isPermitted(KoreConstants.PERM_SECURITY_ROLE_DELETE);
    }

    public Map<String, Boolean> getCheckMap() {
        return checkMap;
    }
}
