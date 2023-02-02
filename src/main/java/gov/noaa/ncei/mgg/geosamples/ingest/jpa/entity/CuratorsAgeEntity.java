package gov.noaa.ncei.mgg.geosamples.ingest.jpa.entity;

import edu.colorado.cires.cmg.jpa.model.EntityWithId;
import edu.colorado.cires.cmg.jpa.util.EntityUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
	AGE_CODE VARCHAR2(2),
	AGE VARCHAR2(20) not null
		constraint CURATORS_AGE_PK
			primary key,
	PUBLISH VARCHAR2(1) default 'Y',
	PREVIOUS_STATE VARCHAR2(1),
	SOURCE_URI VARCHAR2(255)
 */
@Entity
@Table(name = "CURATORS_AGE")
public class CuratorsAgeEntity implements EntityWithId<String> {


  @Id
  @Column(name = "AGE", nullable = false, length = 20)
  private String age;

  @Column(name = "AGE_CODE", length = 2)
  private String ageCode;

  @Column(name = "PUBLISH", length = 1)
  private String publish = "Y";

  @Column(name = "PREVIOUS_STATE", length = 1)
  private String previousState;

  @Column(name = "SOURCE_URI", length = 255)
  private String sourceUri;

  // no getters and setters on purpose, this needs to be here to generate a JPA query only
  @ManyToMany(mappedBy = "ages", fetch = FetchType.LAZY)
  private List<CuratorsIntervalEntity> intervals = new ArrayList<>(0);

  @Override
  public boolean equals(Object o) {
    return EntityUtil.equals(this, o);
  }

  @Override
  public int hashCode() {
    return EntityUtil.hashCodeGeneratedId();
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getAgeCode() {
    return ageCode;
  }

  public void setAgeCode(String ageCode) {
    this.ageCode = ageCode;
  }

  public boolean isPublish() {
    return publish.equals("Y");
  }

  public void setPublish(boolean publish) {
    this.publish = publish ? "Y" : "N";
  }

  public String getPreviousState() {
    return previousState;
  }

  public void setPreviousState(String previousState) {
    this.previousState = previousState;
  }

  public String getSourceUri() {
    return sourceUri;
  }

  public void setSourceUri(String sourceUri) {
    this.sourceUri = sourceUri;
  }

  @Override
  public String getId() {
    return age;
  }
}
