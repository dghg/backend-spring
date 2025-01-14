package com.hidiscuss.backend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ReviewReservation")
public class ReviewReservation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = true)
    private Review review;

    @ManyToOne
    @JoinColumn(name = "discussion_id", nullable = false)
    private Discussion discussion;

    @Column(name = "review_date", nullable = false)
    private LocalDateTime reviewDate;

    @Column(columnDefinition ="boolean default false", name = "reviewer_participated", nullable = false)
    private Boolean reviewerParticipated;

    @Column(columnDefinition ="boolean default false", name = "reviewee_participated", nullable = false)
    private Boolean revieweeParticipated;

    @Column(columnDefinition ="boolean default false", name = "isdone", nullable = false)
    private Boolean isdone;

    @Builder
    public ReviewReservation(Long id, User reviewer, Review review, Discussion discussion, LocalDateTime reviewDate, Boolean reviewerParticipated, Boolean revieweeParticipated, Boolean isdone) {
        this.id = id;
        this.reviewer = reviewer;
        this.review = review;
        this.discussion = discussion;
        this.reviewDate = reviewDate;
        this.reviewerParticipated = reviewerParticipated;
        this.revieweeParticipated = revieweeParticipated;
        this.isdone = isdone;
    }
}
