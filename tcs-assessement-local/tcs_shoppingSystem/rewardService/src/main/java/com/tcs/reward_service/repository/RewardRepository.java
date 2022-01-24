package com.tcs.reward_service.repository;

import com.tcs.reward_service.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward,Long> {
    boolean existsByOrderId(Long orderId);
}
