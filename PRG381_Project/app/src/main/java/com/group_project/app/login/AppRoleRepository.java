package com.group_project.app.login;

import com.group_project.app.login.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByName(String name);
}