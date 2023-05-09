package gov.noaa.ncei.mgg.geosamples.ingest.jpa.entity;

import edu.colorado.cires.cmg.jpa.model.EntityWithId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "GEOSAMPLES_APPROVAL")
public class GeosamplesApprovalEntity implements EntityWithId<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEOSAMPLES_APPROVAL_SEQ")
  @SequenceGenerator(name = "GEOSAMPLES_APPROVAL_SEQ", sequenceName = "GEOSAMPLES_APPROVAL_SEQ", allocationSize = 1)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Version
  @Column(name = "VERSION", nullable = false)
  private Long version;

  @Column(name = "APPROVAL_STATE", nullable = false)
  private String approvalState;

  @Column(name = "REVIEWER_COMMENT")
  private String comment;

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ApprovalState getApprovalState() {
    return ApprovalState.valueOf(approvalState);
  }

  public void setApprovalState(ApprovalState approvalState) {
    this.approvalState = approvalState.name();
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
