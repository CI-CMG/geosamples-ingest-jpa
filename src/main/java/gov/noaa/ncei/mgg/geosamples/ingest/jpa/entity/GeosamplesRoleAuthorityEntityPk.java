package gov.noaa.ncei.mgg.geosamples.ingest.jpa.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class GeosamplesRoleAuthorityEntityPk implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ROLE_ID", nullable = false)
  private Long roleId;

  @Id
  @Column(name = "AUTHORITY_NAME", nullable = false, length = 100)
  private String authorityName;

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getAuthorityName() {
    return authorityName;
  }

  public void setAuthorityName(String authorityName) {
    this.authorityName = authorityName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeosamplesRoleAuthorityEntityPk that = (GeosamplesRoleAuthorityEntityPk) o;
    return Objects.equals(roleId, that.roleId) && Objects.equals(authorityName, that.authorityName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleId, authorityName);
  }

}
