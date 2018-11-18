package com.javapointers.repositories;

import com.javapointers.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepositories extends JpaRepository<Organization,Integer> {
}
