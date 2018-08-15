package cn.com.taiji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.com.taiji.entity.HonorCertificate;

public interface HonorCertificateRepository extends JpaRepository<HonorCertificate, String>, JpaSpecificationExecutor<HonorCertificate> {

}
