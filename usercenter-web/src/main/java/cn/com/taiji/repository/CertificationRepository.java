package cn.com.taiji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.com.taiji.entity.Certification;

public interface CertificationRepository extends JpaRepository<Certification, String>, JpaSpecificationExecutor<Certification> {

}
