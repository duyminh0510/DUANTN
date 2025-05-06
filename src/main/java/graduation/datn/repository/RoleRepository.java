package graduation.datn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import graduation.datn.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
