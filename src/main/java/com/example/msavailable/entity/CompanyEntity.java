package com.example.msavailable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "posted_job_id")
//    private Long postedJobId;
//
//    @Column(name = "master_id")
//    private Long masterId;

    @Column(name = "master_status")
    private String masterStatus;

    @Column(name = "company_status")
    private String companyStatus;

    @Column(name = "master_date_created")
    private LocalDateTime masterDateCreated;

    @Column(name = "master_request_time")
    private LocalDateTime masterRequestTime;

    @Column(name = "accept_time")
    private LocalDateTime acceptTime;

    @Column(name = "remove_time")
    private LocalDateTime removeTime;

    @Column(name = "started_time")
    private LocalDateTime startedTime;

    @Column(name = "comployed_time")
    private LocalDateTime comployedTime;

    @Column(name = "is_active")
    private boolean isActive;
}
