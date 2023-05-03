package gov.noaa.ncei.mgg.geosamples.ingest.jpa.entity;

import edu.colorado.cires.cmg.jpa.model.EntityWithId;
import edu.colorado.cires.cmg.jpa.util.EntityUtil;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GEOSAMPLES_ROLE_AUTHORITY")
@IdClass(GeosamplesRoleAuthorityEntityPk.class)
public class GeosamplesRoleAuthorityEntity implements EntityWithId<GeosamplesRoleAuthorityEntityPk> {

  @Id
  @Column(name = "ROLE_ID", nullable = false)
  private Long roleId;

  @Id
  @Column(name = "AUTHORITY_NAME", nullable = false, length = 100)
  private String authorityName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ROLE_ID", nullable = false, insertable = false, updatable = false)
  private GeosamplesRoleEntity role;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "AUTHORITY_NAME", nullable = false, insertable = false, updatable = false)
  private GeosamplesAuthorityEntity authority;

  @Override
  public boolean equals(Object o) {
    return EntityUtil.equals(this, o);
  }

  @Override
  public int hashCode() {
    return EntityUtil.hashCodeGeneratedId();
  }

  @Override
  public GeosamplesRoleAuthorityEntityPk getId() {
    GeosamplesRoleAuthorityEntityPk id = new GeosamplesRoleAuthorityEntityPk();
    id.setRoleId(roleId);
    id.setAuthorityName(authorityName);
    return id;
  }

  public GeosamplesRoleEntity getRole() {
    return role;
  }

  public void setRole(GeosamplesRoleEntity role) {
    this.role = role;
    if (role == null) {
      this.roleId = null;
    } else {
      this.roleId = role.getId();
    }
  }

  public GeosamplesAuthorityEntity getAuthority() {
    return authority;
  }

  public void setAuthority(GeosamplesAuthorityEntity authority) {
    this.authority = authority;
    if (authority == null) {
      this.authorityName = null;
    } else {
      this.authorityName = authority.getAuthorityName();
    }
  }


}
